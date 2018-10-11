/** 
 * @Project: travel
 * @Title: UrlMapper.java  
 * @Package com.yiklv.travel.filter.dao
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月31日 下午4:41:45  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.base.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yiklv.travel.base.entity.UrlBeans;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.filter.dao
 * <br><b>ClassName:</b> UrlMapper
 * <br><b>Date:</b> 2018年3月31日 下午4:41:45
 */
@Repository("urlDao")
public interface UrlMapper {
    
    /**
     * <b>Description:</b><br> 查询所有的需要登录验证的url
     * @param status
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月31日 下午4:47:05
     * <br><b>Version:</b> 1.0
     */
    public List<UrlBeans> queryAuthorityUrlLists(String status);
    /**
     * <b>Description:</b><br> 根据url判断是否是需要做登录判断
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月31日 下午4:47:08
     * <br><b>Version:</b> 1.0
     */
    public UrlBeans queryAuthorityUrl(String url);
}
