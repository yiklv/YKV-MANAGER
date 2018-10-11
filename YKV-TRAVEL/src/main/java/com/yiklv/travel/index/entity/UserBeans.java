/** 
 * @Project: travel
 * @Title: UserBeans.java  
 * @Package com.yiklv.travel.index.entity
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月22日 下午9:26:01  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.index.entity;

import java.io.Serializable;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.index.entity <br>
 *       <b>ClassName:</b> UserBeans <br>
 *       <b>Date:</b> 2018年3月22日 下午9:26:01
 */

public class UserBeans implements Serializable{
    /**
     * @Fields serialVersionUID : TODO
     */ 
    private static final long serialVersionUID = -1438596757009081650L;

    private String idKey;

    /** */
    private String  userId;
    /** */
    private String userName;
    /** */
    private String password;
    /** */
    private String email;

    private String idNo;
    /** */
    private String mobilePhone;
    /** */
    private String sex;

    private String birthday;

    private String tel;

    public String getIdKey() {
        return idKey;
    }

    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
