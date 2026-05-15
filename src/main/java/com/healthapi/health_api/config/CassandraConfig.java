package com.healthapi.health_api.config;

import java.net.InetSocketAddress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
public class CassandraConfig {

    @Bean
    public CqlSession cassandraSession() {

        return CqlSession.builder()

                .addContactPoint(
                        new InetSocketAddress(
                                "crias-server",
                                9042
                        )
                )

                .withLocalDatacenter("dc1")

                .withKeyspace("health_casdb")

                .build();
    }
}