package com.nabenik.kukulkan.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Generic CORS filter to use services from different port/host. You could/should personalize Allow Origin option to match
 * your domain. It also allows pre-flight (OPTIONS) query for application/json data type.
 *
 * @author tuxtor
 *
 */
@WebFilter(urlPatterns = { "/*" })
public class CORSResponseFilter implements Filter {
 
    public CORSResponseFilter() {
    }
 
    public void destroy() {
    }
 
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) servletRequest;
 
        // Authorize (allow) all domains to consume the content
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers","X-Count-Total, Content-Type, Accept, Origin, Authorization");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Expose-Headers","X-Count-Total, Content-Type, Accept, Origin, Authorization");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST, DELETE");
        
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
 
        if (request.getMethod().equals("OPTIONS")) {
        		((HttpServletResponse) servletResponse).addHeader("Content-Type", "application/json");
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }
 
        chain.doFilter(request, servletResponse);
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
    }
 
}
