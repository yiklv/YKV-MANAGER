package com.yiklv.travel.index.dao;

import com.yiklv.travel.index.entity.TourSpotBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: TourSpotMapper
 * @Package com.yiklv.travel.index.dao
 * @Description: 景点门票baseBean
 * @author: yanguo
 * @date: 2018/8/9 1:23
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Repository("tourSpotDao")
public interface TourSpotMapper {
    /**
     * @ClassName:TourSpotMapper
     * @Description: 查询所有的景点门票
     * @author: yanguo
     * @date:   2018/8/9 1:48
     * @method:
     * @param
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TourSpotBean> queryAllTourSpot();
    /**
     * @ClassName:TourSpotMapper
     * @Description: 通过spotid查询对应的景点门票
     * @author: yanguo
     * @date:   2018/8/9 1:49
     * @method:
      * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public TourSpotBean queryTourSpotById(String spotId);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 通过名称来模糊查询出对应的景点门票
     * @author: yanguo
     * @date:   2018/8/9 1:50
     * @method:
      * @param spotName
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<TourSpotBean> queryTourSpotByName(String spotName);

    /**
     * @ClassName:TourSpotMapper
     * @Description: 插入spot
     * @author: yanguo
     * @date:   2018/8/11 1:11
     * @method:
     * @param tourSpotBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int insertSpotInfo(TourSpotBean tourSpotBean);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 更新景点门票信息
     * @author: yanguo
     * @date:   2018/8/11 1:23
     * @method:
      * @param tourSpotBean
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int updateSpotInfo(TourSpotBean tourSpotBean);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 删除景点门票信息
     * @author: yanguo
     * @date:   2018/8/11 1:23
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public int deleteSpotInfo(String spotId);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 查询景点轮播图
     * @author: yanguo
     * @date:   2018/8/11 14:01
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<String> querySpotSwiperImage(String spotId);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 查询景点的介绍
     * @author: yanguo
     * @date:   2018/8/12 14:13
     * @method:
     * @param spotId
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public String querySpotInstruction(String spotId);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 查询景点的须知、注意事项
     * @author: yanguo
     * @date:   2018/8/12 14:14
     * @method:
     * @param null
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public String querySpotNoteInfo(String spotId);
    /**
     * @ClassName:TourSpotMapper
     * @Description: 查询景点的开放时间
     * @author: yanguo
     * @date:   2018/8/12 15:08
     * @method:
     * @param null
     * @return:
     * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
     * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
     */
    public List<Map<String, Object>> querySpotOpenTime(String spotId);
}
