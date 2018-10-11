package com.yiklv.travel.index.entity;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TicketBookBean
 * @Package com.yiklv.travel.index.entity
 * @Description: 取票人信息实体bean
 * @author: yanguo
 * @date: 2018/9/16 20:57
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TicketBookBean implements Serializable {

    private static final long serialVersionUID = -6955000502782630773L;

    private String userId;

    private String realName;

    private String mobilePhone;

    private String idNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Override
    public String toString() {
        return "TicketBookBean{" +
                "userId='" + userId + '\'' +
                ", realName='" + realName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", idNo='" + idNo + '\'' +
                '}';
    }
}
