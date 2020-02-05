package tom.spring.hellospring.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/api2/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    /*
     * 容器调用的时候
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    /*
     * 容器被销毁时调用
     */
    @Override
    public void destroy() {
        System.out.println("Destory loginFilter");
    }

    /*
     * 请求拦截的时候调用
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter loginFilter url = " + servletRequest.getRemoteAddr());
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        String username = req.getParameter("username");
//        if ("tom".equals(username)) {
            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            resp.sendRedirect("/index.html");
//            return;
//        }
    }
}

