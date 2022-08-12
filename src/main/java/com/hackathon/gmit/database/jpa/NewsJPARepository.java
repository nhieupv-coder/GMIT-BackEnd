/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.Reels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsJPARepository extends JpaRepository<Reels,Long> {
    List<Reels> findAllByDeleteAtNull();
}
