/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.CategoryLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryLocationJPARepository extends JpaRepository<CategoryLocation, Long> {

    @Query("SELECT c FROM CategoryLocation c WHERE c.category.id = ?1 ")
    List<CategoryLocation> getAllByCategoryId(Long categoryId);
}
