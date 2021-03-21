package com.travel.laizheli.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName: JWTUtil
 * @Description: JWT认证
 * @Author: Wangcb
 * @Date: 2021/3/3 10:29
 * @Version: 1.0
 **/
public class JWTUtil {
    // 过期时间5分钟
    private static final long EXPIRE_TIME = 1 * 60 * 1000; // 分钟
    // jwt 密钥
    private static final String SECRET = "jwt_secret";

    /**
     * @Description: 生成token
     * @Param: userId 
    **/        
    public static String sign(String userId) {
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //设置头信息
            HashMap<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //附带userID生成签名
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId",userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @Description: 根据token获取userID
     * @Param: token
    **/
    public static String getUserId(String token) {
        try {
            String userId = JWT.decode(token).getClaim("userId").asString();
            return userId;
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * @Description: 校验token
     * @Param: token 
    **/        
    public static boolean checkSign(String token) {
        if (token==null){
            return false;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

}
