package com.travel.laizheli.config;
import com.travel.laizheli.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: JWTInterceptorConfig
 * @Description: 注册配置
 * @Author: Wangcb
 * @Date: 2021/3/3 11:00
 * @Version: 1.0
 **/
@Configuration
public class JWTInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor()) //注册自定义拦截器
                .addPathPatterns("/**") //拦截所有路径
                .excludePathPatterns("/supplier/login"); //排除登陆请求
    }


}
