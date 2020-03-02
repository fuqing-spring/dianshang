package com.fq.util;

import com.sun.javafx.scene.traversal.Algorithm;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class JWTUtil {
    private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());
    @Value("${jwt.valid.duration}")
    private Long jwtValidDuration;
    @Value("${jwt.issuer}")
    private String issuer;
    private Algorithm algorithm;
    public JWTUtil(@Value("${jwt.HS256.secret}") String jwtHS256Secret){
        logger.info("init jwt util");
        algorithm=Algorithm.HMAC256(jwtHS256Secret);
    }
}
