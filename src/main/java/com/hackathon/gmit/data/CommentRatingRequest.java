/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentRatingRequest implements Serializable {
    @NotNull
    Long LocationId;
    @NotNull
    Long userId;

    @Size(max = 255)
    String comment;

    @Min(1)
    @Max(5)
    int rating;
}
