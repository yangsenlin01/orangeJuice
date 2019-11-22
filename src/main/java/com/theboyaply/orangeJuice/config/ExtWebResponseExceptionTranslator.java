package com.theboyaply.orangeJuice.config;

import com.theboyaply.orangeJuice.config.exception.ExtOAuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Service;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-22
 * @description
 */

@Service
public class ExtWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new ExtOAuthException(oAuth2Exception.getMessage()));
    }

}
