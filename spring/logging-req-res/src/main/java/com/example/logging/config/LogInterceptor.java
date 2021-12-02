package com.example.logging.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log(request, response);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache) throws IOException {
        int status = responseToCache.getStatus();
        String method = requestToCache.getMethod();
        String path = requestToCache.getRequestURI();
        String clientIp = requestToCache.getRemoteAddr();

        String requestPayload = "";
        ContentCachingRequestWrapper requestWrapper = WebUtils.getNativeRequest(requestToCache, ContentCachingRequestWrapper.class);
        if (requestWrapper != null) {
            JsonNode jsonNode = objectMapper.readTree(requestWrapper.getContentAsByteArray());
            requestPayload = jsonNode.toString();
        }

        String responsePayload = "";
        ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(responseToCache, ContentCachingResponseWrapper.class);
        if (responseWrapper != null) {
            JsonNode jsonNode = objectMapper.readTree(responseWrapper.getContentAsByteArray());
            responsePayload = jsonNode.toString();
        }

        responseWrapper.copyBodyToResponse();

        log.info("status : {}, method : {}, path : {}, clientIp : {}, reqPayload : {}, resPayload : {}", status, method, path, clientIp, requestPayload, responsePayload);
    }

}
