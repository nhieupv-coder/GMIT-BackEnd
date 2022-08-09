/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle;

import com.hackathon.gmit.data.CommentRatingRequest;
import com.hackathon.gmit.model.Rating;

public interface SendRating {
    Rating saveOrUpdateCommentRating(CommentRatingRequest comment);
}
