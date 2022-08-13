/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryGroupJPARepository extends JpaRepository<CategoryGroup, Long> {
    List<CategoryGroup> findAllByDeleteAtNull();
}
