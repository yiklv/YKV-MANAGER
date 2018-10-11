package com.yiklv.wxtrv.base.entity;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: WxUserBean
 * @Package com.yiklv.wxtrv.base.action
 * @Description: 小程序用户实体bean
 * @author: yanguo
 * @date: 2018/8/19 16:22
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class WxUserBean implements Serializable {
    private static final long serialVersionUID = -3418827231070499427L;
    private String userId;
    private String nickName;
    private String avatarUrl;
    private String gender;
    private String city;
    private String province;
    private String country;
    private String signature;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "WxUserBean{" +
                "userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", county='" + country + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
