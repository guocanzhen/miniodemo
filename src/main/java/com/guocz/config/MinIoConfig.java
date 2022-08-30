package com.guocz.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guocz
 * @date 2022/8/30 14:04
 */
@Data
@Configuration
public class MinIoConfig {

    @Value("${min.io.endpoint}")
    private String endpoint;

    @Value("${min.io.accessKey}")
    private String accessKey;

    @Value("${min.io.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
    }
}
