/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.Location;
import com.hackathon.gmit.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingJPARepository extends JpaRepository<Rating, Location>  {
    List<Rating> findAllByLocationId(Long locationId);

}
