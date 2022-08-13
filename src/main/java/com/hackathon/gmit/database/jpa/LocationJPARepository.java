/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.CategoryLocation;
import com.hackathon.gmit.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationJPARepository extends JpaRepository<Location, Long>{
    Page<Location> findAllByDeleteAtNullAndCategoryLocationIn(List<CategoryLocation> listCategoryLocation, Pageable pageable);

    Page<Location> findAllByDeleteAtNull(Pageable pageable);

    List<Location> findAllByDeleteAtNull();

    Location findByIdAndDeleteAtIsNull(Long locationId);
}
