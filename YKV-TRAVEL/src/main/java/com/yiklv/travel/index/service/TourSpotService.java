package com.yiklv.travel.index.service;

import com.yiklv.travel.index.entity.*;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TourSpotService
 * @Package com.yiklv.travel.index.service
 * @Description: 景点门票相关服务类
 * @author: yanguo
 * @date: 2018/8/9 2:02
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface TourSpotService {
    /**
     * @ClassName:TourSpotService
     * @Description: 通过景点id查询景点门票相关信息
     * @author: yanguo
     * @date:   2018/8/9 2:04
     * @method:
     * @param spotId 景点id
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public Map<String, Object> queryTourSpotById(String spotId, String detailFlag);
    /**
     * @ClassName:TourSpotService
     * @Description: 模糊查询景点门票
     * @author: yanguo
     * @date:   2018/8/9 2:05
     * @method:
      * @param spotName 景点名称
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TourSpotBean> queryTourSpotByName(String spotName);
    /**
     * @ClassName:TourSpotService
     * @Description: 模糊查询景点门票
     * @author: yanguo
     * @date:   2018/8/9 2:05
     * @method:
     * @param
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TourSpotBean> queryTourSpots();
    /**
     * @ClassName:TourSpotService
     * @Description: 查询景点的详细介绍
     * @author: yanguo
     * @date:   2018/8/12 17:17
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public String querySpotIntroduce(String spotId);
    /**
     * @ClassName:TourSpotService
     * @Description: 插入
     * @author: yanguo
     * @date:   2018/8/11 1:45
     * @method:
     * @param tourSpotBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int insertSpotInfo(TourSpotBean tourSpotBean);
    /**
     * @ClassName:TourSpotService
     * @Description: 更新
     * @author: yanguo
     * @date:   2018/8/11 1:45
     * @method:
     * @param tourSpotBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int updateSpotInfo(TourSpotBean tourSpotBean);
    /**
     * @ClassName:TourSpotService
     * @Description: 更新
     * @author: yanguo
     * @date:   2018/8/11 1:45
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int deleteSpotInfo(String spotId);

    /**
     * @Description: 查询景点的门票信息
     * @author: yanguo
     * @date:   2018/8/13 0:42
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TicketTypeBean> queryTicketInfo(String spotId);

    /**
     * @Description: 查询搜索的关键词
     * @author: yanguo
     * @date:   2018/8/18 12:34
     * @method:
     * @param keyNum
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<SpotKeyWordBean> queryKeyWordList(int keyNum);

    /**
     * @Description: 通过ticketid查询门票
     * @author: yanguo
     * @date:   2018/8/20 22:58
     * @method:
     * @param ticketId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public TicketBean queryTicketDetail(String ticketId);

    /**
     * @Description: 通过ticketid查询门票须知
     * @author: yanguo
     * @date:   2018/8/20 22:58
     * @method:
     * @param ticketId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public String queryTicketNoteDetail(String ticketId);

    /**
     * @Description:  查询取票人信息
     * @author: yanguo
     * @date:   2018/9/16 21:47
     * @method:
     * @param null
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public TicketBookBean queryTicketBookInfo(String userId);

    /**
     * @Description: 录入取票人信息
     * @author: yanguo
     * @date:   2018/9/16 21:55
     * @method:
     * @param null
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public void recordTicketBookInfo(TicketBookBean ticketBookBean);


}
