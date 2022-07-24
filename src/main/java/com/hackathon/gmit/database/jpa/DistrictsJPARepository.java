/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictsJPARepository extends JpaRepository<Districts, Long> {
}
