/** 
 * @Project: travel
 * @Title: CategoryDao.java  
 * @Package com.yiklv.travel.product.dao
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月25日 下午9:16:00  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yiklv.travel.product.entity.CategoryBeans;
import com.yiklv.travel.product.entity.CategoryTypeBean;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.product.dao
 * <br><b>ClassName:</b> CategoryDao
 * <br><b>Date:</b> 2018年3月25日 下午9:16:00
 */
@Repository("categoryDao")
public interface CategoryMapper {
    /**
     * 
     * <b>Description:</b><br> 查询所有的一级类别
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:23:53
     * <br><b>Version:</b> 1.0
     */
    public List<CategoryBeans> queryAllCategory();
    
    /**
     * @Title: queryAllPreCategory   
     * @Description: TODO(查询一级菜单类别)   
     * @param: @return      
     * @return: List<CategoryBeans>      
     * @throws
     */
    public List<CategoryBeans> queryAllPreCategory();
    /**
     * 
     * @Title: queryAllCateoryType   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return      
     * @return: List<CategoryTypeBean>      
     * @throws
     */
    public List<CategoryTypeBean> queryAllCateoryType();
    
    public List<CategoryBeans> queryAllCategoryByType(String categoryType);
    /**
     * 
     * <b>Description:</b><br> 查询一级类别下的二级类别
     * @param parentId
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:31:37
     * <br><b>Version:</b> 1.0
     */
    public List<CategoryBeans> querySubCategorys(String parentId);
    
    /**
     * 
     * <b>Description:</b><br> 查询一级类别下的二级类别
     * @param subCategoryId
     * @return
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:31:37
     * <br><b>Version:</b> 1.0
     */
    public CategoryBeans queryOneSubCategorys(String subCategoryId);
    
    /**
     * 
     * <b>Description:</b><br> 添加一级类别
     * @param category
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:31:40
     * <br><b>Version:</b> 1.0
     */
    public void addCategory(CategoryBeans category);
    /**
     * 
     * <b>Description:</b><br> 更新一级类别
     * @param category
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:32:19
     * <br><b>Version:</b> 1.0
     */
    public void updateCategory(CategoryBeans category);
    /**
     * 
     * <b>Description:</b><br> 删除一级类别
     * @param categoryId
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:32:46
     * <br><b>Version:</b> 1.0
     */
    public void deleteCategory(String categoryId);
    
    /**
     * 
     * <b>Description:</b><br> 添加二级类别
     * @param category
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:31:40
     * <br><b>Version:</b> 1.0
     */
    public void addSubCategory(CategoryBeans subCategory);
    /**
     * 
     * <b>Description:</b><br> 更新二级类别
     * @param category
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:32:19
     * <br><b>Version:</b> 1.0
     */
    public void updateSubCategory(CategoryBeans subCategory);
    /**
     * 
     * <b>Description:</b><br> 删除二级类别
     * @param categoryId
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午9:32:46
     * <br><b>Version:</b> 1.0
     */
    public void deleteSubCategory(String subCategoryId);
}
