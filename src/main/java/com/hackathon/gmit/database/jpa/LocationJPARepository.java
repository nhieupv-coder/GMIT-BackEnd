/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.CategoryLocation;
import com.hackathon.gmit.model.Location;
import com.hackathon.gmit.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationJPARepository extends JpaRepository<Location,Long> {
 Page<Location> findAllByDeleteAtNullAndCategoryLocationIn(List<CategoryLocation> listCategoryLocation, Pageable pageable);
 Page<Location> findAllByDeleteAtNull(Pageable pageable);
}
