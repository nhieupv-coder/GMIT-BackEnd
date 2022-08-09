/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoutesRequest implements Serializable {
    @NotNull
    @JsonProperty("routes_date")
    LocalDate routesDate;
    @NotNull
    @JsonProperty("start_time")
    LocalDateTime startTime;
    @NotNull
    @JsonProperty("end_time")
    LocalDateTime endTime;
    @NotNull
    @JsonProperty("location_id")
    Long locationId;
    @NotNull
    @JsonProperty("user_id")
    Long userId;
    @NotBlank
    String vehicle;

}
