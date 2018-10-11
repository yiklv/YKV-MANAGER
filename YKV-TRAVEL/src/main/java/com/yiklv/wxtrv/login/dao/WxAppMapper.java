package com.yiklv.wxtrv.login.dao;

import com.yiklv.wxtrv.base.entity.WxUserBean;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: WxAppMapper
 * @Package com.yiklv.wxtrv.login
 * @Description: 微信相关的dao层
 * @author: yanguo
 * @date: 2018/8/19 2:11
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface WxAppMapper {
    /**
     * @Description: 查询小程序的appid
     * @author: yanguo
     * @date:   2018/8/19 2:12
     * @method:
     * @param
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public Map<String, Object> queryWxAppInfo();
    /**
     * @Description: 插入微信小程序的信息
     * @author: yanguo
     * @date:   2018/8/19 16:27
     * @method:
     * @param wxUserBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int insertWxUserInfo(WxUserBean wxUserBean);
    /**
     * @Description: 更新用户小程序
     * @author: yanguo
     * @date:   2018/8/19 16:27
     * @method:
     * @param wxUserBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int updateWxUserInfo(WxUserBean wxUserBean);
    /**
     * @Description: 查询登陆用户是否存在
     * @author: yanguo
     * @date:   2018/8/19 17:31
     * @method:
     * @param null
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int queryWxUserInfoExist(String userId);
}
