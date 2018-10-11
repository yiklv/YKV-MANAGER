/** 
 * @Project: travel
 * @Title: LogRecordFilter.java  
 * @Package com.yiklv.travel.filter.filter
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月31日 下午7:37:42  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.filter.filter
 * <br><b>ClassName:</b> LogRecordFilter
 * <br><b>Date:</b> 2018年3月31日 下午7:37:42
 */
public class OperateLogFilter implements Filter {
    
    
    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain) throws IOException,
            ServletException {
        filterChain.doFilter(sRequest, sResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
    }

}
