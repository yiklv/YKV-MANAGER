/** 
 * @Project: travel
 * @Title: IndexController.java  
 * @Package com.yiklv.travel.index.action
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author yang   
 * @date 2018年3月25日 下午5:28:40  
 * Copyright (c) 2018, yang_email0113@163.com All Rights Reserved. 
 * @version V1.0    
 */
package com.yiklv.travel.index.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yiklv.travel.index.entity.TourSpotBean;
import com.yiklv.travel.index.service.TourSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yiklv.travel.Constants;
import com.yiklv.travel.interceptor.annotation.AvoidDuplicateSubmission;
import com.yiklv.travel.product.entity.CategoryBeans;
import com.yiklv.travel.product.entity.CategoryTypeBean;
import com.yiklv.travel.product.service.ProductService;

/**
 * <b>Description:</b><br> 主目录
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.index.action <br>
 *       <b>ClassName:</b> IndexController <br>
 *       <b>Date:</b> 2018年3月25日 下午5:28:40
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ProductService proudctService;
    @Autowired
    private TourSpotService tourSpotService;
    
    @RequestMapping(value = "/indexAction", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        tourSpotService.queryTourSpotById("SP0000000000000001", null);
        //List<CategoryTypeBean> categoryBeans = proudctService.queryAllCategoryList();
        // 一级目录
        //view.addObject("Categorys", categoryBeans);
        view.setViewName("index");
        return view;
    }
    
    @RequestMapping(value = "/wxIndex.do", method = RequestMethod.GET)
    public void wxIndex(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<TourSpotBean> tourSpotList = tourSpotService.queryTourSpots();//tourSpotService.queryTourSpotById("SP0000000000000001");
        System.out.println(tourSpotList);
        resultMap.put("TourSpotList", tourSpotList);
        renderData(response, getJSONString(resultMap));
    }
    @RequestMapping(value="/queryProudcts", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView queryProductsList(){
        ModelAndView view = new ModelAndView();
        
        
        return view;
    }
    
    /**
     * 
     * <b>Description:</b><br> ajax请求返回值封装方法
     * @param response
     * @param data
     * @Note
     * <b>Author:</b> yanguo001
     * <br><b>Date:</b> 2018年3月25日 下午10:39:34
     * <br><b>Version:</b> 1.0
     */
    private void renderData(HttpServletResponse response, String data) {
        PrintWriter printWriter = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            printWriter = response.getWriter();
            printWriter.print(data);
        } catch (IOException ex) {} finally {
            if (null != printWriter) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
    
    
    private String getJSONString(Map<String, Object> resultMap) {
        String jsonResult = JSON.toJSONString(resultMap);
        return jsonResult;
    }
    
    @RequestMapping(value="/flushToken.do",method = RequestMethod.GET)
    @AvoidDuplicateSubmission(needSaveToken = true)
    public void ajaxFlushToken(HttpServletRequest request, HttpServletResponse response){
        renderData(response, request.getSession().getAttribute(Constants.SESSION_TOKEN).toString());
    }

}
