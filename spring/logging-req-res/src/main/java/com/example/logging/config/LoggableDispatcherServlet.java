package com.example.logging.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoggableDispatcherServlet extends DispatcherServlet {

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!(request instanceof ContentCachingRequestWrapper)) {
            request = new ContentCachingRequestWrapper(request);
        }

        if (!(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }

        HandlerExecutionChain handler = getHandler(request);

        try {
            super.doDispatch(request, response);
        } finally {
            log(request, response, handler);
            updateResponse(response);
        }
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache, HandlerExecutionChain handler) throws IOException {
        int status = responseToCache.getStatus();
        String method = requestToCache.getMethod();
        String path = requestToCache.getRequestURI();
        String clientIp = requestToCache.getRemoteAddr();
        String javaMethod = handler.toString();

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

        log.info("status : {}, method : {}, path : {}, clientIp : {}, reqPayload : {}, resPayload : {}, javaMethod : {}", status, method, path, clientIp, requestPayload, responsePayload, javaMethod);
    }

    private void updateResponse(HttpServletResponse response) throws IOException {
        ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        responseWrapper.copyBodyToResponse();
    }

}