package com.ac.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**过滤器实现
 * @author anchao
 * @date 2020/1/7 14:08
 */
@Slf4j
public class UserFilter implements Filter {
    /**
     * 进行过滤
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest re = (HttpServletRequest)request;
        log.info("UserFilter.doFilter.requestURI={}",re.getRequestURI());
        chain.doFilter(request,response);
    }
    /**
     * 销毁
     */
    @Override
    public void destroy() {
        log.info("filter destroy...");
    }
}
