/** 
 * @Project: travel
 * @Title: LoginService.java  
 * @Package com.yiklv.travel.index.service
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月22日 下午9:05:54  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.index.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * <b>Description:</b><br> 登录相关服务
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.index.service
 * <br><b>ClassName:</b> LoginService
 * <br><b>Date:</b> 2018年3月22日 下午9:05:54
 */

public interface LoginService {
    
    /**
     * @Title: initLogin   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return      
     * @return: Map<String,Object>      
     * @throws
     */
    public Map<String, Object> initLogin();
    /**
     * 
     * <b>Description:</b><br> 校验登陆的用户密码
     * @param userId
     * @param password
     * @param session
     * @return
     * @throws Exception 
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月22日 下午10:27:11
     * <br><b>Version:</b> 1.0
     */
    public Map<String,Object> validateUser(Map<String,Object> paramMap) throws Exception;
}
