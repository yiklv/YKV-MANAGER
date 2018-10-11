package com.yiklv.wxtrv.login.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.yiklv.travel.utils.http.HttpRequestUtil;
import com.yiklv.wxtrv.base.entity.WxUserBean;
import com.yiklv.wxtrv.login.dao.WxAppMapper;
import com.yiklv.wxtrv.login.service.WxLoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: WxLoginServiceImpl
 * @Package com.yiklv.wxtrv.login.service
 * @Description: 微信小程序登陆的服务实现类
 *  @author: yanguo
 * @date: 2018/8/19 2:07
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service("wxLoginService")
public class WxLoginServiceImpl implements WxLoginService {
    private static Log logger = LogFactory.getLog(WxLoginServiceImpl.class);
    @Resource
    private WxAppMapper wxAppDao;

    /**
     *
     * @Description: 微信小程序的登陆验证
     * @author: yanguo
     * @date: 2018/8/19 2:07
     * @method: authWxLogin
     * @param paramMap
     * @return: resultMap
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public Map<String, Object> authWxLogin(Map<String, Object> paramMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> appInfo = wxAppDao.queryWxAppInfo();
        String appId = (String) appInfo.get("AppId");
        String appSecret = (String) appInfo.get("AppSecret");
        String wxCode = (String) paramMap.get("Code");
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, Object> requestUrlParam = new HashMap<String, Object>();
        requestUrlParam.put("appid", appId);//小程序appId
        requestUrlParam.put("secret", appSecret);
        requestUrlParam.put("js_code", wxCode);//小程序端返回的code
        requestUrlParam.put("grant_type", "authorization_code");//默认参数
        try {
            String result = HttpRequestUtil.httpGet(requestUrl, requestUrlParam);
                JSONObject jsonObject = JSON.parseObject(result);

            Object errorCode = jsonObject.get("errcode");
            if(errorCode != null && !"".equals(errorCode)) {
                resultMap.put("errorCode", errorCode);
                resultMap.put("errorMsg", jsonObject.get("errmsg"));
            } else{
                if(logger.isDebugEnabled()){
                    logger.debug(jsonObject.get("openid") + " <-->  " + jsonObject.get("session_key") + " <--> " + paramMap.get("Signature"));
                }
                WxUserBean wxUserBean = new WxUserBean();
                JSONObject rawDataJson = JSON.parseObject(paramMap.get("RawData").toString());
                //入库
                String userId = jsonObject.getString("openid");
                wxUserBean.setUserId(userId);
                wxUserBean.setNickName(rawDataJson.getString("nickName"));
                wxUserBean.setAvatarUrl(rawDataJson.getString("avatarUrl"));
                wxUserBean.setGender(rawDataJson.getString("gender"));
                wxUserBean.setCity(rawDataJson.getString("city"));
                wxUserBean.setProvince(rawDataJson.getString("province"));
                wxUserBean.setCountry(rawDataJson.getString("country"));
                wxUserBean.setSignature(paramMap.get("Signature").toString());
                int existCount = wxAppDao.queryWxUserInfoExist(userId);
                if(existCount > 0) {
                    //wxAppDao.updateWxUserInfo(wxUserBean);
                } else {
                    wxAppDao.insertWxUserInfo(wxUserBean);
                }
                /*Map<String, Object> rawDataMap = rawDataJson.toJavaObject(Map.class);
                logger.debug(rawDataMap);*/
                String encryptedData =  (String) paramMap.get("EncrypteData");
                String iv =  (String) paramMap.get("Iv");
                String sessionKey = jsonObject.getString("session_key");
                JSONObject encryptUser = encryptUserData(encryptedData,sessionKey,iv);
                Object userJson = JSON.toJSON(wxUserBean);
                logger.debug(userJson);
                resultMap.put("errorCode", -1);
                resultMap.put("errorMsg", "success");
                resultMap.put("UserInfo", wxUserBean);
                resultMap.put("OpenId", userId);
            }

        } catch (Exception e) {
            logger.error("HTTP SEND is ERROR : " + e.getMessage());
        }
        return resultMap;
    }
    /**
     * @Description: 转换用户敏感信息
     * @author: yanguo
     * @date:   2018/8/19 16:13
     * @method:
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    private JSONObject encryptUserData(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSON.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidParameterSpecException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            logger.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidAlgorithmParameterException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchProviderException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
