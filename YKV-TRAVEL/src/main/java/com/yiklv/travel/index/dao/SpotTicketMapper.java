package com.yiklv.travel.index.dao;

import com.yiklv.travel.index.entity.TicketBean;
import com.yiklv.travel.index.entity.TicketTypeBean;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: SpotTicketMapper
 * @Package com.yiklv.travel.index.dao
 * @Description: 景点门票查询dao层
 * @author: yanguo
 * @date: 2018/8/13 0:19
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface SpotTicketMapper {
    /**
     * @Description: 查询景点的门票种类
     * @author: yanguo
     * @date:   2018/8/13 0:28
     * @method:
     * @param spotId 景点id
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TicketTypeBean> queryTktType(String spotId);

    /**
     * @Description: 查询景点门票
     * @author: yanguo
     * @date:   2018/8/13 0:30
     * @method:
     * @param spotId 景点id
     * @param tktTypeId 门票类型id
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TicketBean> querySpotTicket(Map<String, String> paramMap);
    /**
     * @Description: 通过ticketid查询门票
     * @author: yanguo
     * @date:   2018/8/20 22:53
     * @method:
     * @param ticketId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public TicketBean queryTicketDetail(String ticketId);
    /**
     * @Description: 通过ticketid查询门票须知
     * @author: yanguo
     * @date:   2018/8/20 22:54
     * @method:
     * @param ticketId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public String queryTicketNoteDetail(String ticketId);
}
