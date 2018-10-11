package com.yiklv.travel.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yiklv.travel.Constants;
import com.yiklv.travel.index.entity.UserBeans;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.yiklv.travel.base.entity.UrlBeans;
import com.yiklv.travel.base.service.ICacheService;

/**
 * <b>Description:</b><br>
 * 
 * @author yanguo001
 * @version 1.0
 * @Note <b>ProjectName:</b> travel <br>
 *       <b>PackageName:</b> com.yiklv.travel.filter <br>
 *       <b>ClassName:</b> AuthorityFilter <br>
 *       <b>Date:</b> 2018年3月31日 上午11:35:43
 */
public class AuthorityFilter extends HttpServlet implements Filter {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 6985999577430193631L;
    private static final Log  log              = LogFactory.getLog(AuthorityFilter.class);

//    public SqlSessionFactory  sqlSessionFactory;
    @Autowired
    public ICacheService      iCacheService;

    /*public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }*/

    public void init(FilterConfig arg0) throws ServletException {
        // do something
    }

    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sRequest;
        HttpServletResponse response = (HttpServletResponse) sResponse;
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        String contextPath = request.getContextPath();
        if (url.equals("/index"))
            url += "/";
        if (log.isDebugEnabled())
            log.debug("-----------------------> " + url);
        boolean urlFlag = false;// url判断状态
        // 查询所有的需要登陆的url
        List<UrlBeans> urlLists = iCacheService.queryAuthorityUrls("Y");
        if (urlLists != null && urlLists.size() > 0) {
            for (UrlBeans urlBeans : urlLists) {
                String authUrl = urlBeans.getUrl();
                if (url.equals(authUrl)) {
                    UserBeans user = (UserBeans) session.getAttribute(Constants.SESSION_ADMINISTRATOR);
                    if (user == null) {
                        urlFlag = true;
                        break;
                    }
                }
            }
            if (urlFlag) {
                response.sendRedirect(contextPath + "/login/loginPage.do");
                return;
            }
        }
        filterChain.doFilter(sRequest, sResponse);
    }
}
