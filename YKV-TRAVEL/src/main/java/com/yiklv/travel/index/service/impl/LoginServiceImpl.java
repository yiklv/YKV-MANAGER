/** 
 * @Project: travel
 * @Title: LoginServiceImpl.java  
 * @Package com.yiklv.travel.index.service.impl
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月22日 下午9:06:10  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.index.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yiklv.travel.Constants;
import com.yiklv.travel.ResultConstants;
import com.yiklv.travel.index.dao.UserMapper;
import com.yiklv.travel.index.entity.UserBeans;
import com.yiklv.travel.index.service.LoginService;
import com.yiklv.travel.utils.encrypt.EncryptUtil;
import com.yiklv.travel.utils.encrypt.Md5Utils;
import com.yiklv.travel.utils.str.StringUtils;

/**
 * <b>Description:</b><br>
 * 登录相关服务
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.index.service.impl <br>
 *       <b>ClassName:</b> LoginServiceImpl <br>
 *       <b>Date:</b> 2018年3月22日 下午9:06:10
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    public Log         logger = LogFactory.getLog(LoginServiceImpl.class);

    @Value("#{configProperties['asc.key']}")
    private String     AESKEY;

    @Resource
    private UserMapper userDao;

    @Override
    public Map<String, Object> validateUser(Map<String, Object> paramMap) throws Exception {
        Map<String, Object> resultMap = null;
        String userId = (String) paramMap.get("UserId");
        String password = (String) paramMap.get("Password");
        UserBeans userInfo = userDao.queryUserInfo(userId);
        logger.info("查询用户");
        if (userInfo == null) {
            logger.info("查询用户不存在");
            resultMap = StringUtils.resultParam("F", ResultConstants.LOGIN_USER_IS_NULL);
            return resultMap;
        }
        if (StringUtils.isEmpty(password)) {
            logger.info("密码是空");
            resultMap = StringUtils.resultParam("F", ResultConstants.LOGIN_USER_PASSWORD_IS_NULL);
            return resultMap;
        }
        String aesBaseKey = (String) paramMap.get("AesBaseKey");
        String encryKey = StringUtils.base64decode(aesBaseKey);
        String aesPwd = EncryptUtil.AES_CBC_Decrypt(password, encryKey.getBytes(), encryKey.getBytes());
        String encryptPwd = Md5Utils.encrytPassword(aesPwd);
        if (!encryptPwd.equals(userInfo.getPassword().toUpperCase())) {
            logger.info("密码不正确");
            resultMap = StringUtils.resultParam("F", ResultConstants.LOGIN_USER_PASSWORD_IS_NOT_CORRECT);
            return resultMap;
        }
        resultMap = StringUtils.resultParam("S", "");
        resultMap.put("UserInfo", userInfo);
        return resultMap;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.yiklv.travel.index.service.LoginService#initLogin()
     */
    @Override
    public Map<String, Object> initLogin() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("aesKey", AESKEY);
        return result;
    }
}
