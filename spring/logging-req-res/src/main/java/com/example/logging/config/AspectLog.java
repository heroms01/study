package com.example.logging.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

@Aspect
@Slf4j
@Component
public class AspectLog {
    @Around("execution(* *..controller.*.*(..))")
    public Object loggingBefore(ProceedingJoinPoint pjp) throws Throwable {
        ContentCachingRequestWrapper request = WebUtils.getNativeRequest(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest(), ContentCachingRequestWrapper.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(request.getContentAsByteArray());
        log.info("req : {}", jsonNode.toString());

        Object result = pjp.proceed();

        ResponseEntity<?> res = (ResponseEntity<?>) result;
        ObjectMapper mapper = new ObjectMapper();
        log.info("res : {}", mapper.writeValueAsString(res.getBody()));

        return result;
    }
}