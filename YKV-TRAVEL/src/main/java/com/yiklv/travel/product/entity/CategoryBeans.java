/** 
 * @Project: travel
 * @Title: CategoryBeans.java  
 * @Package com.yiklv.travel.product.entity
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月25日 下午9:15:16  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.product.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Description:</b><br> 
 * @author yanguo001
 * @version 1.0
 * @Note
 * <b>ProjectName:</b> travel
 * <br><b>PackageName:</b> com.yiklv.travel.product.entity
 * <br><b>ClassName:</b> CategoryBeans
 * <br><b>Date:</b> 2018年3月25日 下午9:15:16
 */
public class CategoryBeans implements Serializable{
    /**
     * @Fields serialVersionUID : TODO
     */ 
    private static final long serialVersionUID = 418084567870061375L;
    /***/
    private String categoryId;
    /***/
    private String categoryName;
    /***/
    private String categoryType;
    /***/
    private List<CategoryBeans> categoryBeans;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public List<CategoryBeans> getCategoryBeans() {
		return categoryBeans;
	}

	public void setCategoryBeans(List<CategoryBeans> categoryBeans) {
		this.categoryBeans = categoryBeans;
	}
    
    
}
