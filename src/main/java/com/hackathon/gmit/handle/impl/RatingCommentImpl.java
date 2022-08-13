/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.CommentRatingRequest;
import com.hackathon.gmit.data.CommentRatingResponse;
import com.hackathon.gmit.database.jpa.LocationJPARepository;
import com.hackathon.gmit.database.jpa.RatingJPARepository;
import com.hackathon.gmit.database.jpa.UserJPARepository;
import com.hackathon.gmit.handle.GetListRating;
import com.hackathon.gmit.handle.SendRating;
import com.hackathon.gmit.model.Location;
import com.hackathon.gmit.model.Rating;
import com.hackathon.gmit.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingCommentImpl implements GetListRating, SendRating {
    @Autowired
    RatingJPARepository ratingJPARepository;
    @Autowired
    LocationJPARepository locationJPARepository;
    @Autowired
    UserJPARepository userJPARepository;

    @Override
    public List<CommentRatingResponse> getListRatingCommentByLocationId(Long locationId) {
        List<Rating> listRating = ratingJPARepository.findAllByLocationId(locationId);

        return listRating.stream().map(i -> CommentRatingResponse.builder()
                .locationId(i.getLocation().getId())
                .userId(i.getUser().getId())
                .nameUser(i.getUser().getFullName())
                .comment(i.getComment())
                .commentTime(i.getCommentTime())
                .rating(i.getRate())
                .build()).collect(Collectors.toList());
    }

    @Override
    public Rating saveOrUpdateCommentRating(CommentRatingRequest commentRatingRequest) {
        Location location = locationJPARepository
                .findByIdAndDeleteAtIsNull(commentRatingRequest.getLocationId());
        Users users = userJPARepository
                .findByIdAndDeleteAtIsNull(commentRatingRequest.getUserId());
        Rating rating = new Rating();
        rating.setUser(users);
        rating.setLocation(location);
        rating.setComment(commentRatingRequest.getComment());
        rating.setRate(commentRatingRequest.getRating());
        rating.setCommentTime(LocalDateTime.now(ZoneId.of("Vietnam/Hanoi")));
        rating.setDeleteAt(null);
       return ratingJPARepository.save(rating);
    }
}
