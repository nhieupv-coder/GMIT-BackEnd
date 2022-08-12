/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.service;

import com.hackathon.gmit.config.AWSCloudConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PathsService {

    @Autowired
    AWSCloudConfig awsCloudConfig;

    public String toFullPath(String imageName) {
        if (!imageName.isBlank()) {
            return awsCloudConfig.getOriginPath().concat(imageName);
        }
       return StringUtils.EMPTY;
    }
}
