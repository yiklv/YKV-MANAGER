/** 
 * @Project: travel
 * @Title: UserDao.java  
 * @Package com.yiklv.travel.index.dao
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月22日 下午9:05:39  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.index.dao;

import org.springframework.stereotype.Repository;

import com.yiklv.travel.index.entity.UserBeans;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.index.dao
 * <br><b>ClassName:</b> UserDao
 * <br><b>Date:</b> 2018年3月22日 下午9:05:39
 */
@Repository("userDao")
public interface UserMapper {
    /**
     * 
     * <b>Description:</b><br> 
     * @param username
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月22日 下午10:12:32
     * <br><b>Version:</b> 1.0
     */
    public UserBeans queryUserInfo(String userId) throws Exception;
    
}
