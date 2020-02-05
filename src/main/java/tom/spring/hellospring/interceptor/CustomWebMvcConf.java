package tom.spring.hellospring.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConf implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 调用时依照注册顺序调用
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");
        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
