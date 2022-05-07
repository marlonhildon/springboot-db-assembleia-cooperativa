package br.com.marlonhildon.assembleia.cooperativa.config;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Gerador de CorrelationId com o objetivo de atribuir um ID a cada única requisição.
 */
@Component
public class CorrelationIdConfig implements HandlerInterceptor {

    public static final String CORRELATION_ID = "CorrelationId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        MDC.put(CORRELATION_ID, getCorrelationId());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.remove(CORRELATION_ID);
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}