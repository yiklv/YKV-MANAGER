/** 
 * @Project: travel
 * @Title: ICacheServiceImpl.java  
 * @Package com.yiklv.travel.base.service.impl
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月31日 下午8:22:41  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yiklv.travel.base.dao.UrlMapper;
import com.yiklv.travel.base.entity.UrlBeans;
import com.yiklv.travel.base.service.ICacheService;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.base.service.impl <br>
 *       <b>ClassName:</b> ICacheServiceImpl <br>
 *       <b>Date:</b> 2018年3月31日 下午8:22:41
 */
@Service(ICacheService.SERVICEID)
public class ICacheServiceImpl implements ICacheService {
    private static final Log logger = LogFactory.getLog(ICacheServiceImpl.class);
    
    @Resource
    public UrlMapper urlDao;
    
//    @Cacheable(value="urlCache", key="#status")
    public List<UrlBeans> queryAuthorityUrls(String status){
        if(logger.isDebugEnabled()){
           logger.debug("------------------------->urlCache start"); 
        }
        List<UrlBeans> urlLists = urlDao.queryAuthorityUrlLists("Y");
        return urlLists;
    }
}
