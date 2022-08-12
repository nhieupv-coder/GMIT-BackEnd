package com.hackathon.gmit.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AWSCloudConfig {
    @Value("${aws-cloud.access-key}")
    String accessKey;
    @Value("${aws-cloud.secret-key}")
    String secretKey;
    @Value("${aws-cloud.bucket-image}")
    String bucketImage;
    @Value("${aws-cloud.origin-path}")
    String originPath;
}
