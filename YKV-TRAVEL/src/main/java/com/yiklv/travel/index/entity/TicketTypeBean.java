package com.yiklv.travel.index.entity;

import java.io.Serializable;
import java.util.List;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TicketTypeBean
 * @Package com.yiklv.travel.index.entity
 * @Description:
 * @author: yanguo
 * @date: 2018/8/13 0:22
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TicketTypeBean implements Serializable {

    private static final long serialVersionUID = -8293704162045780731L;

    private String ticketTypeId;
    private String ticketTypeName;
    private String ticketTypeImg;

    private List<TicketBean> ticketBeanList;

    public String getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(String ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getTicketTypeImg() {
        return ticketTypeImg;
    }

    public void setTicketTypeImg(String ticketTypeImg) {
        this.ticketTypeImg = ticketTypeImg;
    }

    public List<TicketBean> getTicketBeanList() {
        return ticketBeanList;
    }

    public void setTicketBeanList(List<TicketBean> ticketBeanList) {
        this.ticketBeanList = ticketBeanList;
    }

    @Override
    public String toString() {
        return "TicketTypeBean{" +
                "ticketTypeId='" + ticketTypeId + '\'' +
                ", ticketTypeName='" + ticketTypeName + '\'' +
                ", ticketTypeImg='" + ticketTypeImg + '\'' +
                '}';
    }
}
