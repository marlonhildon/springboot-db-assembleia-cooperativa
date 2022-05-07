package br.com.marlonhildon.assembleia.cooperativa.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CorrelationIdConfigTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private Object handler;
    @Mock
    private Exception ex;

    @InjectMocks
    private CorrelationIdConfig correlationIdConfig;

    @Test
    void preHandleTest() {
        boolean preHandleSucesso = correlationIdConfig.preHandle(request, response, handler);
        assertNotNull(MDC.get(CorrelationIdConfig.CORRELATION_ID));
        assertTrue(preHandleSucesso);
    }

    @Test
    void afterCompletionTest() {
        correlationIdConfig.afterCompletion(request, response, handler, ex);
        assertNull(MDC.get(CorrelationIdConfig.CORRELATION_ID));
    }
}