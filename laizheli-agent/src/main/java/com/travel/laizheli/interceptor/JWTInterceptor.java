package com.travel.laizheli.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.laizheli.common.api.Result;
import com.travel.laizheli.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @ClassName: JWTInterceptor
 * @Description: 拦截器，进行token验证
 * @Author: Wangcb
 * @Date: 2021/3/3 10:50
 * @Version: 1.0
 **/
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<String, String> map = new HashMap<>();
        try {
            boolean verify = JWTUtil.checkSign(token);//验证令牌
            if (!verify){
                map.put("message", "token为空!");
            }else {
                return true;//放行请求
            }
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("message", "无效签名!");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("message", "token过期!");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("message", "token算法不一致!");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "token无效!!");
        }
        map.put("code", "401");//设置状态
        //将 map 转为json  jackson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json); //前台返回数据
        return false;
    }
}
