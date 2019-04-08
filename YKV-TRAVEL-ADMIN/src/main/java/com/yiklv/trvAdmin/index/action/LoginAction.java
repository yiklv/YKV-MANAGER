package com.yiklv.trvAdmin.index.action;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: LoginAction
 * @Package com.yiklv.trvAdmin.index.action
 * @Description: 登录controller层
 * @author: yanguo
 * @date: 2019/2/8 20:09
 * @Copyright: 2019 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/login")
public class LoginAction {
    @Value("${aes.common.key}")
    private String aesKey;
    @Value("${aes.common.iv}")
    private String aesIv;

    /**
     * @Description: 首页跳转登录页面
     * @author: yanguo
     * @date:   2019/2/8 20:30
     * @method
     * @param request
     * @param response
     * @return:
     * @exception
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping("/loginPage.do")
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("login_flag");
        ModelAndView modelAndView = new ModelAndView("regist/login");
        modelAndView.addObject("aesKey", Base64.encode(aesKey.getBytes()));
        modelAndView.addObject("aesIv",Base64.encode(aesIv.getBytes()));
        return modelAndView;
    }
    /**
     * @Description: TODO
     * @author: yanguo
     * @date:   2019/2/8 20:36
     * @method:
     * @param loginUsername
     * @param loginPassword
     * @return:
     * @exception
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/login.do", method=RequestMethod.POST)
    @ResponseBody
    public String loginValidate(@RequestParam("loginUsername") String loginUsername,@RequestParam("loginPassword") String loginPassword,
                                      HttpServletRequest request, HttpServletResponse response){

        System.out.println(loginPassword);
        return "SUCCESS";
    }
}
