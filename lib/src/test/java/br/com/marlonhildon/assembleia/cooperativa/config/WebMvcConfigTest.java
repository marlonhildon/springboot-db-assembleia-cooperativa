package br.com.marlonhildon.assembleia.cooperativa.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@ExtendWith(MockitoExtension.class)
class WebMvcConfigTest {

    @Mock
    private CorrelationIdConfig correlationIdConfig;

    @Mock
    private InterceptorRegistry registry;

    @InjectMocks
    private WebMvcConfig webMvcConfig;

    @Test
    void addInterceptorsTest() {
        webMvcConfig.addInterceptors(registry);
    }
}