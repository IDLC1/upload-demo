package tom.spring.hellospring.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {

    /*
    *  调用方法之前
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginIntercepter preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /*
    *  调用方法之后，视图渲染之前
    */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntercepter postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /*
    *  方法调用完成之后
    */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginIntercepter afterHandle");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
