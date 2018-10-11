/** 
 * @Project: travel
 * @Title: LoginController.java  
 * @Package com.yiklv.travel.index.action
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月22日 下午8:43:19  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.index.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yiklv.travel.Constants;
import com.yiklv.travel.ResultConstants;
import com.yiklv.travel.index.service.LoginService;
import com.yiklv.travel.interceptor.annotation.AvoidDuplicateSubmission;
import com.yiklv.travel.utils.image.code.RandomValidateCode;
import com.yiklv.travel.utils.str.RandomUtil;
import com.yiklv.travel.utils.str.StringUtils;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.index.action <br>
 *       <b>ClassName:</b> LoginController <br>
 *       <b>Date:</b> 2018年3月22日 下午8:43:19
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private Log          logger = LogFactory.getLog(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginPage.do")
    @AvoidDuplicateSubmission(needSaveToken = true)
    public ModelAndView loginForward(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        // Map<String, Object> result = loginService.initLogin();
        try {
            // 随机生成16位的字符串，然后base64加密 传到前端页面
            String aesKey = StringUtils.base64encode(RandomUtil.generateString(16));
            HttpSession session = request.getSession();
            session.setAttribute(Constants.SESSION_AESCBCKEY, aesKey);
            model.addObject("AESKEY", aesKey);
            model.setViewName("login/login");
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug("login/loginPage.do error: " + e.getMessage());
            }
            // model.setViewName("");
        }
        return model;
    }
    
    @RequestMapping("/registerPre.do")
    @AvoidDuplicateSubmission(needSaveToken = true)
    public ModelAndView registForward(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("regist/register");
        return model;
    }

    @RequestMapping("/getImageCode.do")
    @ResponseBody
    public void getImageCode(HttpServletRequest request, HttpServletResponse response) {
        if (logger.isDebugEnabled())
            logger.debug("LoginController.getImageCode start====================");
        HttpSession session = request.getSession();
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);// 输出图片方法
            logger.debug(session.getAttribute(RandomValidateCode.RANDOMCODEKEY));
        } catch (Exception e) {
            logger.info("get imageCode is error and message: " + e.getMessage());
        }
    }

    /**
     * 
     * <b>Description:</b><br>
     * 
     * @param request
     * @param response
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月22日 下午10:32:16 <br>
     *       <b>Version:</b> 1.0
     */
    @RequestMapping(value = "/logout.do")
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.SESSION_ADMINISTRATOR);
        return "forward:/index/indexAction.do";
    }

    /**
     * 
     * <b>Description:</b><br>
     * 
     * @param request
     * @param response
     * @return
     * @Note <b>Author:</b> yanguo001 <br>
     *       <b>Date:</b> 2018年3月22日 下午10:32:16 <br>
     *       <b>Version:</b> 1.0
     */
    @RequestMapping(value = "/login.do")
    @ResponseBody
    @AvoidDuplicateSubmission(needRemoveToken = true)
    public Map<String, Object> login(@RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password, @RequestParam(value = "_vTokenName") String _vTokenName,
            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = null;
        try {
            HttpSession session = request.getSession();
            String sessionToken = (String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY);
            String upperToken = _vTokenName == null ? "" : _vTokenName.toUpperCase();
            if (!sessionToken.equals(upperToken)) {
                resultMap = StringUtils.resultParam("F", ResultConstants.LOGIN_USER_TOKEN_IS_NOT_CORRECT);
            }
            else {
                // base64加密后的key
                String aesBaseKey = (String) session.getAttribute(Constants.SESSION_AESCBCKEY);
                if (StringUtils.isEmpty(aesBaseKey)) {
                    logger.info("session 为空");
                    resultMap = StringUtils.resultParam("F", ResultConstants.SYSTEM_ERROR);
                }
                else {
                    Map<String, Object> paramMap = new HashMap<String, Object>();
                    paramMap.put("UserId", userId);
                    paramMap.put("Password", password);
                    paramMap.put("AesBaseKey", aesBaseKey);
                    resultMap = loginService.validateUser(paramMap);
                    session.removeAttribute(Constants.SESSION_AESCBCKEY);
                    if ("S".equals(resultMap.get("Success"))) {
                        session.removeAttribute(Constants.SESSION_ADMINISTRATOR);
                        session.setAttribute(Constants.SESSION_ADMINISTRATOR, resultMap.get("UserInfo"));
                    }
                }
            }
        } catch (Exception e) {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>exception error:" + e.getMessage());
            resultMap = StringUtils.resultParam("F", ResultConstants.SYSTEM_ERROR);
        }
        return resultMap;
    }
}
