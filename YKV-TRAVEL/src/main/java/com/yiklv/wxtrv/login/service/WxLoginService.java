package com.yiklv.wxtrv.login.service;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: WxLoginService
 * @Package com.yiklv.wxtrv.login.action
 * @Description: 微信登陆的服务类
 * @author: yanguo
 * @date: 2018/8/19 2:05
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface WxLoginService {
    /**
     * @Description: 微信小程序的登陆验证
     * @author: yanguo
     * @date:   2018/8/19 2:07
     * @method:
     * @param paramMap
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public Map<String, Object> authWxLogin(Map<String, Object> paramMap);

}
