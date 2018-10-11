package com.yiklv.wxtrv.base.action;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.yiklv.com
 *
 * @version V1.0.0
 * @ProjectName YKV-MANAGER
 * @Title: BaseController
 * @Package com.yiklv.wxtrv.base.action
 * @Description:
 * @author: yanguo
 * @date: 2018/8/11 1:35
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved.
 * 注意：本内容仅限于深公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class BaseController {
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
    public void renderData(HttpServletResponse response, Map<String, Object> resultMap) {
        PrintWriter printWriter = null;
        String data = null;
        try {
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            data = getJSONString(resultMap);
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
}
