package com.theboyaply.orangeJuice.config.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-22
 * @description
 */

@JsonSerialize(using = OAuthExceptionSerialize.class)
public class ExtOAuthException extends OAuth2Exception {

    public ExtOAuthException(String msg) {
        super(msg);
    }

}
