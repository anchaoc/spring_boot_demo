package com.ac.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author anchao
 * @date 2020/1/7 14:08
 */
@Slf4j
public class UserFilter implements Filter {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest re = (HttpServletRequest)request;
        log.info("UserFilter.doFilter.requestURI={}",re.getRequestURI());

//        if(1>0){
//            throw new RuntimeException("filter throw");
//        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("filter destroy...");
    }
}
