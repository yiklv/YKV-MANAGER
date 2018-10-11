package com.yiklv.wxtrv.login.action;

import com.yiklv.travel.Constants;
import com.yiklv.wxtrv.base.action.BaseController;
import com.yiklv.wxtrv.login.service.WxLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: WxLoginController
 * @Package com.yiklv.wxtrv
 * @Description: 登陆相关的controller
 * @author: yanguo
 * @date: 2018/8/19 1:48
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/wxLogin")
public class WxLoginController extends BaseController {
    @Autowired
    private WxLoginService wxLoginService;
    /**
     * @Description: 登陆
     * @author: yanguo
     * @date:   2018/9/25 20:47
     * @method:
     * @param
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value = "/authCode.do", method = RequestMethod.POST)
    public void authWxLogin(@RequestParam(value = "code",required = false) String code,
                            @RequestParam(value = "rawData",required = false) String rawData,
                            @RequestParam(value = "signature",required = false) String signature,
                            @RequestParam(value = "encrypteData",required = false) String encrypteData,
                            @RequestParam(value = "iv",required = false) String iv,
                            HttpServletRequest request, HttpServletResponse response){
        //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        Map<String, Object> paramMap = new HashMap<String,Object>();
        paramMap.put("Code", code);
        paramMap.put("RawData", rawData);
        paramMap.put("Signature", signature);
        paramMap.put("EncrypteData", encrypteData);
        paramMap.put("Iv", iv);
        Map<String, Object> result = wxLoginService.authWxLogin(paramMap);
        renderData(response, result);
    }

}
