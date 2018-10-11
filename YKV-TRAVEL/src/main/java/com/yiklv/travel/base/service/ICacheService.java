/** 
 * @Project: travel
 * @Title: ICacheService.java  
 * @Package com.yiklv.travel.base.service
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月31日 下午8:22:00  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.base.service;

import java.util.List;

import com.yiklv.travel.base.entity.UrlBeans;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.base.service
 * <br><b>ClassName:</b> ICacheService
 * <br><b>Date:</b> 2018年3月31日 下午8:22:00
 */

public interface ICacheService {
    
    final String SERVICEID="ICacheService";
    
    
    public List<UrlBeans> queryAuthorityUrls(String status);
}
