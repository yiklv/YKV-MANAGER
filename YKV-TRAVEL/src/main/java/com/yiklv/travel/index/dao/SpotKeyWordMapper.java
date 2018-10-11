package com.yiklv.travel.index.dao;


import com.yiklv.travel.index.entity.SpotKeyWordBean;

import java.util.List;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: SpotKeyWordMapper
 * @Package com.yiklv.travel.index.dao
 * @Description: 关键词dao层
 * @author: yanguo
 * @date: 2018/8/18 12:19
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface SpotKeyWordMapper {

    /**
     * @Description: 搜索展示的关键词
     * @author: yanguo
     * @date:   2018/8/18 12:21
     * @method:
     * @param keyNum 查询关键词个数
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<SpotKeyWordBean> queryKeyWordList(int keyNum);

}
