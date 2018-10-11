package com.yiklv.travel.product.entity;

import java.io.Serializable;
import java.util.List;
/**
 * @ClassName  CategoryTypeBean   
 * @Description TODO(这里用一句话描述这个类的作用)   
 * @author 一科律科技  
 * @date  2018年6月9日 下午2:01:41   
 *     
 * @Copyright 2018 www.yiklv.com Inc. All rights reserved. 
 * 注意：本内容仅限于一科律科技公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class CategoryTypeBean implements Serializable {

    /**   
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
     */
    private static final long serialVersionUID = -6199941137031867526L;
    
    private String categoryType;
    
    private String categoyTypeDesc;
    
    private String categoryImg;
    
    private List<CategoryBeans> categoryBeans;

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoyTypeDesc() {
        return categoyTypeDesc;
    }

    public void setCategoyTypeDesc(String categoyTypeDesc) {
        this.categoyTypeDesc = categoyTypeDesc;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public List<CategoryBeans> getCategoryBeans() {
        return categoryBeans;
    }

    public void setCategoryBeans(List<CategoryBeans> categoryBeans) {
        this.categoryBeans = categoryBeans;
    }
    
}
