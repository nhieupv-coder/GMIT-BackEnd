/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle;

import com.hackathon.gmit.data.CommentRatingResponse;

import java.util.List;

public interface GetListRating {
    List<CommentRatingResponse> getListRatingCommentByLocationId(Long locationId);
}
