package com.cognizant.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class LogFilter {
    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Bean
    public GlobalFilter globalLogFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("Incoming request: {} {}", request.getMethod(), request.getURI());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("Completed request: {} {} -> status {}", request.getMethod(), request.getURI(), exchange.getResponse().getStatusCode());
            }));
        };
    }
}

