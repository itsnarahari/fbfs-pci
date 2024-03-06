package com.fbfs.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@Component
@Configuration
public class AppConfigs {

    @Bean(name = "auditingDateTimeProvider")
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
}
