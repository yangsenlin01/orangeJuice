package com.theboyaply.orangeJuice.config.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-22
 * @description
 */

@Service
public class OAuthExceptionSerialize extends StdSerializer<ExtOAuthException> {

    private static final String ERROR_TAG = "error";
    private static final String MESSAGE_TAG = "message";
    private static final String PATH_TAG = "path";
    private static final String TIMESTAMP_TAG = "timestamp";

    public OAuthExceptionSerialize() {
        super(ExtOAuthException.class);
    }

    @Override
    public void serialize(ExtOAuthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        gen.writeStartObject();
        gen.writeStringField(ERROR_TAG, String.valueOf(value.getHttpErrorCode()));
        gen.writeStringField(MESSAGE_TAG, value.getMessage());
        gen.writeStringField(PATH_TAG, request.getServletPath());
        gen.writeStringField(TIMESTAMP_TAG, ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        if (value.getAdditionalInformation() != null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}
