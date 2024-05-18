package com.dugu.ddd.infra.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dugu.ddd.common.constants.Constants;

import java.util.Date;

/**
 * TokenUtils
 *
 * @author cihun
 * @date 2024/5/12 12:30
 */
public class TokenUtils {

    /**
     * 过期时间 24 小时
     */
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    /**
     * 密钥
     */
    private static final String SECRET = "chen";


    /**
     * 创建token
     *
     * @param username username
     * @return The encrypted token
     */
    public static String createToken(String username) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim(Constants.USER_NAME, username)
                //到期时间
                .withExpiresAt(date)
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(algorithm);

    }
    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param password 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String password) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(Constants.USER_NAME, username)
                    .build();
            //效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            //log.info("登录验证成功!");
            return true;
        } catch (Exception exception) {
            //log.error("JwtUtil登录验证失败!");
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(Constants.USER_NAME).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
