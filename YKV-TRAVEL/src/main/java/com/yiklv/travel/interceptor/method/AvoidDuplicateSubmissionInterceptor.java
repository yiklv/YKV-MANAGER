package com.yiklv.travel.interceptor.method;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yiklv.travel.Constants;
import com.yiklv.travel.interceptor.annotation.AvoidDuplicateSubmission;
import com.yiklv.travel.utils.str.RandomUtil;

/**   
 * @ClassName:  AvoidDuplicateSubmissionInterceptor   
 * @Description:TODO(防止重复提交过滤器)   
 * @author: 一科律科技  
 * @date:   2018年6月30日 下午2:16:46   
 *     
 * @Copyright: 2018 www.yiklv.com Inc. All rights reserved. 
 * 注意：本内容仅限于一科律科技公司内部传阅，禁止外泄以及用于其他的商业目 
 */ 
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger LOG = Logger.getLogger(AvoidDuplicateSubmissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
        if (annotation != null) {
            boolean needSaveSession = annotation.needSaveToken();
            if (needSaveSession) {
                request.getSession(false).setAttribute(Constants.SESSION_TOKEN, RandomUtil.generateString(8));
            }

            boolean needRemoveSession = annotation.needRemoveToken();
            if (needRemoveSession) {
                if (isRepeatSubmit(request)) {
                    LOG.warn("please don't repeat submit,url:" + request.getServletPath() + "]=============================");
                    return false;
                }
                request.getSession(false).removeAttribute(Constants.SESSION_TOKEN);
            }
        }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute(Constants.SESSION_TOKEN);
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter(Constants.SESSION_TOKEN);
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }

}
