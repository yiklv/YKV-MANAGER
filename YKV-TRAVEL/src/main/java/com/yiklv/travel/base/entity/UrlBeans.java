/** 
 * @Project: travel
 * @Title: UrlBeans.java  
 * @Package com.yiklv.travel.filter.entity
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月31日 下午4:49:55  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.base.entity;

import java.io.Serializable;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.filter.entity
 * <br><b>ClassName:</b> UrlBeans
 * <br><b>Date:</b> 2018年3月31日 下午4:49:55
 */
public class UrlBeans implements Serializable{
    
    /**
     * @Fields serialVersionUID :
     */ 
    private static final long serialVersionUID = -2710075335176044548L;
    
    private int idKey;
    
    private String url;
    
    private String urlDesc;
    
    private String status;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlDesc() {
        return urlDesc;
    }

    public void setUrlDesc(String urlDesc) {
        this.urlDesc = urlDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdKey() {
        return idKey;
    }

    public void setIdKey(int idKey) {
        this.idKey = idKey;
    }
    
    
}
