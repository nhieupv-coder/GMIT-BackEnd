/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.FeaturedNewsPageResponse;
import com.hackathon.gmit.data.FeaturedNewsResponse;
import com.hackathon.gmit.data.NewsResponse;
import com.hackathon.gmit.database.jpa.FeaturedNewsJPARepository;
import com.hackathon.gmit.database.jpa.NewsJPARepository;
import com.hackathon.gmit.handle.GetFeaturedNews;
import com.hackathon.gmit.handle.GetListNews;
import com.hackathon.gmit.model.FeaturedNews;
import com.hackathon.gmit.model.Reels;
import com.hackathon.gmit.service.PathsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class NewsImpl implements GetListNews,
        GetFeaturedNews {
    @Autowired
    PathsService pathsService;

    @Autowired
    NewsJPARepository newsJPARepository;

    @Autowired
    FeaturedNewsJPARepository featuredNewsJPARepository;

    @Override
    public List<NewsResponse> getListNews() {
        List<Reels> listNewModel = newsJPARepository.findAllByDeleteAtNull();
        List<NewsResponse> listResponse = listNewModel.stream()
                .map(i -> NewsResponse.builder()
                        .id(i.getId())
                        .userId(i.getUsers()
                                .getId())
                        .title(i.getTitleNews())
                        .postAt(i.getPostingTime())
                        .avatarUser(pathsService.toFullPath(i.getUsers().getAvatar()))
                        .imageNews(pathsService.toFullPath(i.getImageNews()))
                        .build()).collect(Collectors.toList());
        return listResponse;
    }

    @Override
    public FeaturedNewsPageResponse get(Pageable pageable) {
        Page<FeaturedNews> featuredNewsPageable = featuredNewsJPARepository
                .findAllByDeleteAtNullOrderByPriorityAsc(pageable);
        List<FeaturedNews> listFeaturedNews = featuredNewsPageable.getContent();
        List<FeaturedNewsResponse> contents = listFeaturedNews.stream().map(i -> FeaturedNewsResponse.builder()
                .id(i.getId())
                .title(i.getTitleNews())
                .rangeTimePost(convertTimeToText(i.getPostingTime()))
                .image(pathsService.toFullPath(i.getImageCardNews()))
                .build()).collect(Collectors.toList());
        FeaturedNewsPageResponse response = FeaturedNewsPageResponse.builder()
                .contents(contents)
                .totalPage(featuredNewsPageable.getTotalPages())
                .totalElement(featuredNewsPageable.getTotalElements())
                .currentPage(featuredNewsPageable.getNumber())
                .size(featuredNewsPageable.getSize())
                .build();
        return response;
    }

    private String convertTimeToText(LocalDateTime postTime) {
        if(Objects.isNull(postTime)){
            return StringUtils.EMPTY;
        }
        StringBuilder strBuilder = new StringBuilder();

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Vietnam/Hanoi"));
        Duration duration = Duration.between(postTime, now);
        long day = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();

        if (day > 0) {
            strBuilder.append(day + " ngày ");
            hours -= day * 24;
            if(hours == 0){
                strBuilder.append("trước ");
            }
        }
        if (hours > 0) {
            strBuilder.append(hours + " giờ ");
            minutes -= hours * 60;
            if(minutes == 0){
                strBuilder.append("trước ");
            }
        }
        if(minutes > 0){
            strBuilder.append(minutes + " phút trước ");
        }
        return strBuilder.toString();
    }
}
