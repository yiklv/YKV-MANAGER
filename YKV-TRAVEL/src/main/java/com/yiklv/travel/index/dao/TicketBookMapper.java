package com.yiklv.travel.index.dao;

import com.yiklv.travel.index.entity.TicketBookBean;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TicketBookMapper
 * @Package com.yiklv.travel.index.dao
 * @Description: 订单取票信息Dao
 * @author: yanguo
 * @date: 2018/9/16 21:10
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface TicketBookMapper {
    /**
     * @Description: 查询订票的取票人信息
     * @author: yanguo
     * @date:   2018/9/16 21:25
     * @method:
     * @param userId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public TicketBookBean queryTicketBookInfo(String userId);

    /**
     * @Description: 修改订票人信息
     * @author: yanguo
     * @date:   2018/9/16 21:28
     * @method:
     * @param ticketBookBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int updateTicketBookInfo(TicketBookBean ticketBookBean);

    /**
     * @Description: 插入订票人信息
     * @author: yanguo
     * @date:   2018/9/16 21:39
     * @method:
     * @param ticketBookBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int insertTicketBookInfo(TicketBookBean ticketBookBean);
}
