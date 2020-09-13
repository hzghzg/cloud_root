package com.huangda7.provider.infrastructure.config;

import com.huangda7.provider.domain.orderupdate.AuditAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.huangda7.provider.infrastructure.constant.OrderConstants.AUDIT_AWARE;


@Configuration
@EnableJpaAuditing(auditorAwareRef = AUDIT_AWARE)
public class JPAConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAwareImpl();
    }
}
