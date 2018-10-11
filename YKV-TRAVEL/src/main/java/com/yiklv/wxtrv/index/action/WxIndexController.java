package com.yiklv.wxtrv.index.action;

import com.alibaba.fastjson.JSON;
import com.yiklv.travel.index.entity.*;
import com.yiklv.travel.index.service.TourSpotService;
import com.yiklv.travel.utils.image.ImageUtils;
import com.yiklv.wxtrv.base.action.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: WxIndexController
 * @Package com.yiklv.travel
 * @Description: 小程序的主controller
 * @author: yanguo
 * @date: 2018/8/11 1:26
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/wxIndex")
public class WxIndexController extends BaseController {

    @Autowired
    private TourSpotService tourSpotService;


    /**
     * @Description: x小程序首頁
     * @author: yanguo
     * @date:   2018/9/20 21:54
     * @method:
     * @param request
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value = "/wxIndex.do", method = RequestMethod.GET)
    public void wxIndex(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<TourSpotBean> tourSpotList = tourSpotService.queryTourSpots();
        resultMap.put("TourSpotList", tourSpotList);
        renderData(response, resultMap);
    }

    /**
     * @ClassName:WxIndexController
     * @Description: TODO
     * @author: yanguo
     * @date:   2018/8/11 5:18
     * @method:
      * @param
     * @return: @RequestParam("spotId") String spotId,
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value = "/wxSpotDetail.do", method = RequestMethod.POST)
    public void wxSpotDetail(@RequestParam("spotId") String spotId, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap =  tourSpotService.queryTourSpotById(spotId, "detail");
        List<TicketTypeBean> ticketList = tourSpotService.queryTicketInfo(spotId);
        resultMap.put("TicketList", ticketList);
        renderData(response, resultMap);
    }
    /**
     * @Description: 查詢小程序景點介紹
     * @author: yanguo
     * @date:   2018/9/20 21:55
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/spotIntroduce.do", method = RequestMethod.POST)
    public void wxSpotIntroduce(@RequestParam("spotId") String spotId, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String content = tourSpotService.querySpotIntroduce(spotId);
        resultMap.put("SpotIntroInfo", content);
        renderData(response, resultMap);
    }
    /**
     * @Description: 查詢搜索中的关键词
     * @author: yanguo
     * @date:   2018/9/20 21:56
     * @method:
     * @param keyNum
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/spotKeyWords.do", method = RequestMethod.POST)
    public void wxSpotKeyWord(int keyNum, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(keyNum == 0){
            keyNum = 6;
        }
        List<SpotKeyWordBean> keyWordBeanList = tourSpotService.queryKeyWordList(keyNum);
        resultMap.put("KeyWordBeanList", keyWordBeanList);
        renderData(response, resultMap);
    }

    /**
     * @Description: 小程序搜索
     * @author: yanguo
     * @date:   2018/9/20 21:58
     * @method:
     * @param spotName
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/wxSearchSpot.do", method = RequestMethod.POST)
    public void wxSearchSpot(@RequestParam("spotName") String spotName, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(spotName == null || "".equals(spotName)){
            return;
        }
        List<TourSpotBean> TourSpotSearchList = tourSpotService.queryTourSpotByName(spotName);
        resultMap.put("TourSpotSearchList", TourSpotSearchList);
        renderData(response, resultMap);
    }
    /**
     * @Description: 查詢沒票詳情
     * @author: yanguo
     * @date:   2018/9/20 21:58
     * @method:
     * @param ticketId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/wxTicketDetail.do", method = RequestMethod.POST)
    public void wxQueryTicketDetail(@RequestParam("ticketId")String ticketId, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        TicketBean ticketBean = tourSpotService.queryTicketDetail(ticketId);
        resultMap.put("TicketDetail", ticketBean);
        renderData(response, resultMap);
    }
    /**
     * @Description: 查詢門票的介紹詳情
     * @author: yanguo
     * @date:   2018/9/20 21:59
     * @method:
     * @param ticketId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/wxTicketNoteDetail.do", method = RequestMethod.POST)
    public void wxQueryTicketNoteDetail(@RequestParam("ticketId")String ticketId, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String ticketNoteDetail = tourSpotService.queryTicketNoteDetail(ticketId);
        resultMap.put("TicketNoteDetail", ticketNoteDetail);
        renderData(response, resultMap);
    }
    /**
     * @Description: 查詢用戶的取票人信息
     * @author: yanguo
     * @date:   2018/9/20 22:00
     * @method:
     * @param userId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/wxQueryTicketBook.do", method = RequestMethod.POST)
    public void wxQueryTicketBook(@RequestParam("userId")String userId, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        TicketBookBean ticketBookBean =  tourSpotService.queryTicketBookInfo(userId);
        resultMap.put("TicketBookBean", ticketBookBean);
        renderData(response, resultMap);
    }
    /**
     * @Description: 下門票訂單
     * @author: yanguo
     * @date:   2018/9/20 22:00
     * @method:
     * @param userId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @RequestMapping(value="/wxTicketOrder.do", method = RequestMethod.POST)
    public void wxOrderTicket(@RequestParam("userId")String userId, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        TicketBookBean ticketBookBean =  tourSpotService.queryTicketBookInfo(userId);
        resultMap.put("TicketBookBean", ticketBookBean);
        renderData(response, resultMap);
    }

}
