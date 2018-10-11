/** 
 * @Project: travel
 * @Title: ProductServiceImpl.java  
 * @Package com.yiklv.travel.product.service.impl
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月25日 下午9:58:15  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yiklv.travel.product.dao.CategoryMapper;
import com.yiklv.travel.product.entity.CategoryBeans;
import com.yiklv.travel.product.entity.CategoryTypeBean;
import com.yiklv.travel.product.service.ProductService;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.product.service.impl
 * <br><b>ClassName:</b> ProductServiceImpl
 * <br><b>Date:</b> 2018年3月25日 下午9:58:15
 */
@Service("proudctService")
public class ProductServiceImpl implements ProductService{
    
    @Resource
    private CategoryMapper categoryDao;

    @Override
    public List<CategoryBeans> queryAllCategory() {
        return categoryDao.queryAllCategory();
    }

    @Override
    public List<CategoryBeans> queryAllSubCategory(String parentId) {
        return categoryDao.querySubCategorys(parentId);
    }

    /* (non-Javadoc)
     * @see com.yiklv.travel.product.service.ProductService#queryAllCategoryList()
     */
    @Override
    public List<CategoryTypeBean> queryAllCategoryList() {
        List<CategoryTypeBean> categoryBean = categoryDao.queryAllCateoryType();
        for(CategoryTypeBean catgType: categoryBean){
            String categoryType = catgType.getCategoryType();
            List<CategoryBeans> categoryList = categoryDao.queryAllCategoryByType(categoryType);
            for(CategoryBeans category: categoryList){
                List<CategoryBeans> subCategory = queryAllSubCategory(category.getCategoryId());
                category.setCategoryBeans(subCategory);
            }
            catgType.setCategoryBeans(categoryList);
        }
        return categoryBean;
    }

}
