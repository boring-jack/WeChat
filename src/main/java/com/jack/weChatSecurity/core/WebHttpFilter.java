package com.jack.weChatSecurity.core;

import com.jack.weChatSecurity.config.JsonConfig;
import com.jack.weChatSecurity.core.bean.RES;
import com.jack.weChatSecurity.core.exception.TokenExpireException;
import com.jack.weChatSecurity.core.exception.UnknownTokenException;
import com.jack.weChatSecurity.core.urlmatcher.DefaultUrlMatcher;
import com.jack.weChatSecurity.core.exception.UnknownUrlException;
import com.jack.weChatSecurity.core.urlmatcher.UrlMatcher;
import com.jack.weChatSecurity.utils.JsonUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.List;

public class WebHttpFilter implements Filter {
    private static String CONFIG="weChatSecurity.json";
    private static UrlMatcher urlMatcher=new DefaultUrlMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request;
        HttpServletResponse response;

        if(servletRequest instanceof HttpServletRequest&&servletResponse instanceof HttpServletResponse){
            request=(HttpServletRequest) servletRequest;
            response=(HttpServletResponse) servletResponse;

            String url=request.getRequestURI();

            RES res=null;

            try {
                if(urlMatcher.urlMatcher(url)){
                    System.out.println("拦截的URL:"+url);
                    String token=request.getParameter("token");

                    SecurityHelper.login(token);
                }
            } catch (TokenExpireException e){
                res=new RES().setCode(2).setMsg(e.getMessage());
            } catch (UnknownTokenException e){
                res=new RES().setCode(3).setMsg(e.getMessage());
            } catch (UnknownUrlException e) {
                res=new RES().setCode(1).setMsg(e.getMessage());
            } finally {
                if(res!=null){
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter writer= response.getWriter();
                    writer.write(JsonUtil.getJsonByObject(res));
                    writer.close();
                    return;
                }else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化
        String json=JsonUtil.getStringByJsonFile(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG));
        try {
            JsonConfig jsonConfig=JsonUtil.getObjectByJson(json,JsonConfig.class);
            List<String> inUrl=jsonConfig.getSecurityConfig().getInUrl();
            List<String> exUrl=jsonConfig.getSecurityConfig().getExUrl();
            urlMatcher.init(inUrl,exUrl);
            SecurityHelper.init(jsonConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            SecurityHelper.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
