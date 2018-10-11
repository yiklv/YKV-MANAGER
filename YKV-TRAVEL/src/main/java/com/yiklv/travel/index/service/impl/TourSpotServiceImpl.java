package com.yiklv.travel.index.service.impl;

import com.yiklv.travel.index.dao.SpotKeyWordMapper;
import com.yiklv.travel.index.dao.SpotTicketMapper;
import com.yiklv.travel.index.dao.TicketBookMapper;
import com.yiklv.travel.index.dao.TourSpotMapper;
import com.yiklv.travel.index.entity.*;
import com.yiklv.travel.index.service.TourSpotService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TourSpotServiceImpl
 * @Package com.yiklv.travel.index.service.impl
 * @Description: 景点门票相关服务类实现类
 * @author: yanguo
 * @date: 2018/8/9 2:06
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service("tourSpotService")
public class TourSpotServiceImpl implements TourSpotService {
    @Resource
    private TourSpotMapper tourSpotDao;
    @Resource
    private SpotTicketMapper ticketMapper;

    @Resource
    private TicketBookMapper ticketBookDao;

    @Resource
    private SpotKeyWordMapper keyWordDao;

    @Override
    public Map<String, Object> queryTourSpotById(String spotId, String detailFlag) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        TourSpotBean tourSpotBean = tourSpotDao.queryTourSpotById(spotId);
        if("detail".equals(detailFlag)){
            List<String> imageUrlList = tourSpotDao.querySpotSwiperImage(spotId);
            tourSpotBean.setSwiperImages(imageUrlList);
            List<Map<String, Object>> openTimeList = tourSpotDao.querySpotOpenTime(spotId);
            resultMap.put("SpotOpenTime", openTimeList);
        }
        resultMap.put("TourSpotInfo", tourSpotBean);
        return resultMap;
    }

    @Override
    public List<TourSpotBean> queryTourSpotByName(String spotName) {
        List<TourSpotBean> tourSpotBeanList = tourSpotDao.queryTourSpotByName(spotName);
        return tourSpotBeanList;
    }

    @Override
    public List<TourSpotBean> queryTourSpots() {
        List<TourSpotBean> tourSpotBeanList = tourSpotDao.queryAllTourSpot();
        return tourSpotBeanList;
    }

    /**
     * @param spotId
     * @ClassName:TourSpotService
     * @Description: 查询景点的详细介绍
     * @author: yanguo
     * @date: 2018/8/12 17:17
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public String querySpotIntroduce(String spotId) {
        return tourSpotDao.querySpotInstruction(spotId);
    }


    /**
     * @param tourSpotBean
     * @ClassName:TourSpotService
     * @Description: 插入
     * @author: yanguo
     * @date: 2018/8/11 1:45
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public int insertSpotInfo(TourSpotBean tourSpotBean) {
        return tourSpotDao.insertSpotInfo(tourSpotBean);
    }

    /**
     * @param tourSpotBean
     * @ClassName:TourSpotService
     * @Description: 更新
     * @author: yanguo
     * @date: 2018/8/11 1:45
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public int updateSpotInfo(TourSpotBean tourSpotBean) {
        return tourSpotDao.updateSpotInfo(tourSpotBean);
    }

    /**
     * @param spotId
     * @ClassName:TourSpotService
     * @Description: 更新
     * @author: yanguo
     * @date: 2018/8/11 1:45
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public int deleteSpotInfo(String spotId) {
        return tourSpotDao.deleteSpotInfo(spotId);
    }

    /**
     * @param spotId
     * @Description: 查询景点的门票信息
     * @author: yanguo
     * @date: 2018/8/13 0:42
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public List<TicketTypeBean> queryTicketInfo(String spotId) {
        List<TicketTypeBean> tickctList = ticketMapper.queryTktType(spotId);
        if(tickctList != null && tickctList.size() >0){
            for(TicketTypeBean tktType: tickctList){
                Map<String, String> paramMap = new HashMap<>();
                paramMap.put("spotId", spotId);
                paramMap.put("tktTypeId", tktType.getTicketTypeId());
                List<TicketBean> ticketInfoList = ticketMapper.querySpotTicket(paramMap);
                tktType.setTicketBeanList(ticketInfoList);
            }
        }
        return tickctList;
    }

    /**
     * @param keyNum
     * @Description: 查询搜索的关键词
     * @author: yanguo
     * @date: 2018/8/18 12:34
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public List<SpotKeyWordBean> queryKeyWordList(int keyNum) {
        return keyWordDao.queryKeyWordList(keyNum);
    }

    /**
     * @param ticketId
     * @Description: 通过ticketid查询门票
     * @author: yanguo
     * @date: 2018/8/20 22:58
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public TicketBean queryTicketDetail(String ticketId) {
        return ticketMapper.queryTicketDetail(ticketId);
    }

    /**
     * @param ticketId
     * @Description: 通过ticketid查询门票须知
     * @author: yanguo
     * @date: 2018/8/20 22:58
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public String queryTicketNoteDetail(String ticketId) {
        return ticketMapper.queryTicketNoteDetail(ticketId);
    }

    /**
     * @param userId
     * @Description: 查询取票人信息
     * @author: yanguo
     * @date: 2018/9/16 21:47
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public TicketBookBean queryTicketBookInfo(String userId) {

        return ticketBookDao.queryTicketBookInfo(userId);
    }

    /**
     * @param ticketBookBean
     * @Description: 录入取票人信息
     * @author: yanguo
     * @date: 2018/9/16 21:55
     * @method:
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    @Override
    public void recordTicketBookInfo(TicketBookBean ticketBookBean) {
        int updateRes = ticketBookDao.updateTicketBookInfo(ticketBookBean);
        if(updateRes == 0){
            ticketBookDao.insertTicketBookInfo(ticketBookBean);
        }
    }


}
