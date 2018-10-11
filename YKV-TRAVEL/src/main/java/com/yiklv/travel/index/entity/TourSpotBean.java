package com.yiklv.travel.index.entity;

import java.io.Serializable;
import java.util.List;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TourSpotBean
 * @Package com.yiklv.travel.index.entity
 * @Description: 景点门票bean
 * @author: yanguo
 * @date: 2018/8/9 1:26
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class TourSpotBean implements Serializable {

    private static final long serialVersionUID = 41400694618169806L;
    private String spotId;
    private String spotName;
    private String imageUrl;
    private String cityId;
    private String cityName;
    private String areaId;
    private String areaName;
    private double spotPrice;
    private double spotOldPrice;
    private String spotLevel;
    private String spotAddr;
    private List<String> swiperImages;
    public String spotNoteDesc;

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }


    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public double getSpotPrice() {
        return spotPrice;
    }

    public void setSpotPrice(double spotPrice) {
        this.spotPrice = spotPrice;
    }

    public double getSpotOldPrice() {
        return spotOldPrice;
    }

    public void setSpotOldPrice(double spotOldPrice) {
        this.spotOldPrice = spotOldPrice;
    }

    public String getSpotLevel() {
        return spotLevel;
    }

    public void setSpotLevel(String spotLevel) {
        this.spotLevel = spotLevel;
    }

    public String getSpotAddr() {
        return spotAddr;
    }

    public void setSpotAddr(String spotAddr) {
        this.spotAddr = spotAddr;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getSwiperImages() {
        return swiperImages;
    }

    public String getSpotNoteDesc() {
        return spotNoteDesc;
    }

    public void setSpotNoteDesc(String spotNoteDesc) {
        this.spotNoteDesc = spotNoteDesc;
    }

    public void setSwiperImages(List<String> swiperImages) {
        this.swiperImages = swiperImages;
    }

    @Override
    public String toString() {
        return "TourSpotBean{" +
                "spotId='" + spotId + '\'' +
                ", spotName='" + spotName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", spotPrice='" + spotPrice + '\'' +
                ", spotOldPrice='" + spotOldPrice + '\'' +
                ", spotLevel='" + spotLevel + '\'' +
                ", spotAddr='" + spotAddr + '\'' +
                '}';
    }
}
