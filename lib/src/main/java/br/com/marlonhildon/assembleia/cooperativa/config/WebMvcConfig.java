package br.com.marlonhildon.assembleia.cooperativa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Adiciona o interceptador responsável por gerar o CorrelationID
 * @see CorrelationIdConfig
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private CorrelationIdConfig correlationIdConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(correlationIdConfig);
    }
}