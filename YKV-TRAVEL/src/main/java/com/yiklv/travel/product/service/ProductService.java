/** 
 * @Project: travel
 * @Title: ProductService.java  
 * @Package com.yiklv.travel.product.service
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月25日 下午9:57:47  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.product.service;

import java.util.List;

import com.yiklv.travel.product.entity.CategoryBeans;
import com.yiklv.travel.product.entity.CategoryTypeBean;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.product.service
 * <br><b>ClassName:</b> ProductService
 * <br><b>Date:</b> 2018年3月25日 下午9:57:47
 */
public interface ProductService {
    /**
     * 
     * <b>Description:</b><br> 查询所有一级目录
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午10:00:15
     * <br><b>Version:</b> 1.0
     */
    public List<CategoryBeans> queryAllCategory();
    /**
     * 
     * <b>Description:</b><br> 查询一级目录下的二集目录
     * @param categoryId
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午10:01:31
     * <br><b>Version:</b> 1.0
     */
    public List<CategoryBeans> queryAllSubCategory(String parentId);
    /**
     * 
     * @Title: queryAllCategoryList   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return      
     * @return: List<CategoryTypeBean>      
     * @throws
     */
    public List<CategoryTypeBean> queryAllCategoryList();
    
}
