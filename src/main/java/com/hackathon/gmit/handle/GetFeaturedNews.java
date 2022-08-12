/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle;

import com.hackathon.gmit.data.FeaturedNewsPageResponse;
import org.springframework.data.domain.Pageable;

public interface GetFeaturedNews {
    FeaturedNewsPageResponse get(Pageable pageable);
}
