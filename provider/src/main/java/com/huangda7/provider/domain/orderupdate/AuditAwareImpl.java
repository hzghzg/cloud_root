package com.huangda7.provider.domain.orderupdate;


import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.huangda7.provider.infrastructure.constant.OrderConstants.AUDIT_AWARE;
import static com.huangda7.provider.infrastructure.constant.OrderConstants.SYSTEM_USER;


@Component(AUDIT_AWARE)
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SYSTEM_USER);
    }
}