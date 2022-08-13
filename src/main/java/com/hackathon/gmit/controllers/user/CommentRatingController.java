/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.CommentRatingRequest;
import com.hackathon.gmit.data.CommentRatingResponse;
import com.hackathon.gmit.handle.GetListRating;
import com.hackathon.gmit.handle.SendRating;
import com.hackathon.gmit.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment-rating")
@CrossOrigin("*")
public class CommentRatingController {
    @Autowired
    GetListRating getListRating;
    @Autowired
    SendRating sendRating;

    @GetMapping("{location_id}")
    public ResponseEntity<List<CommentRatingResponse>> getListRatingByLocationId(
            @PathVariable("location_id") Optional<Long> locationId
    ) {
        if (locationId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getListRating.getListRatingCommentByLocationId(locationId.get()));
    }

    @PutMapping()
    public ResponseEntity<CommentRatingResponse> saveOrUpdateCommentRating(
            @Validated @RequestBody CommentRatingRequest commentRatingRequest
    ) {
        Rating rating = sendRating.saveOrUpdateCommentRating(commentRatingRequest);
        CommentRatingResponse commentRatingResponse = CommentRatingResponse.builder().userId(rating.getUser().getId())
                .comment(rating.getComment())
                .rating(rating.getRate())
                .nameUser(rating.getUser().getFullName())
                .commentTime(rating.getCommentTime())
                .locationId(rating.getLocation().getId()).build();
        return ResponseEntity.ok().body(commentRatingResponse);
    }
}
