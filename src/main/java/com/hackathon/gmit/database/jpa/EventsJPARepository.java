/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.database.jpa;

import com.hackathon.gmit.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsJPARepository extends JpaRepository<Events, Long> {
}
