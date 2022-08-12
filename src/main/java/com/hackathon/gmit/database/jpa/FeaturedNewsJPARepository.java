/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.FeaturedNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturedNewsJPARepository extends JpaRepository<FeaturedNews, Long> {
    Page<FeaturedNews> findAllByDeleteAtNullOrderByPriorityAsc(Pageable pageable);
}
