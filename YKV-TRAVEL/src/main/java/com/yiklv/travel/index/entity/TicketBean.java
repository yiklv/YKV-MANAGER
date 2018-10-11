package com.yiklv.travel.index.entity;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TicketBean
 * @Package com.yiklv.travel.index.entity
 * @Description:
 * @author: yanguo
 * @date: 2018/8/13 0:24
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TicketBean implements Serializable {
    private static final long serialVersionUID = 8756176968493062916L;

    private String ticketId;
    private String ticketName;
    private String ticketPrice;

    private String ticketOldPirce;

    private String ticketNoteDesc;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketOldPirce() {
        return ticketOldPirce;
    }

    public void setTicketOldPirce(String ticketOldPirce) {
        this.ticketOldPirce = ticketOldPirce;
    }

    public String getTicketNoteDesc() {
        return ticketNoteDesc;
    }

    public void setTicketNoteDesc(String ticketNoteDesc) {
        this.ticketNoteDesc = ticketNoteDesc;
    }

    @Override
    public String toString() {
        return "TicketBean{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketName='" + ticketName + '\'' +
                ", ticketprice='" + ticketPrice + '\'' +
                ", ticketOldPirce='" + ticketOldPirce + '\'' +
                '}';
    }
}
