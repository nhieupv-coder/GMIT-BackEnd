/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.FeaturedNewsPageResponse;
import com.hackathon.gmit.data.NewsResponse;
import com.hackathon.gmit.handle.GetFeaturedNews;
import com.hackathon.gmit.handle.GetListNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    GetListNews getListNews;

    @Autowired
    GetFeaturedNews getFeaturedNews;

    @GetMapping
    public ResponseEntity<FeaturedNewsPageResponse> getListFeatured(@PageableDefault(page = 0, size = 4)
                                                                    Pageable pageable) {
        FeaturedNewsPageResponse response = getFeaturedNews.get(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reels")
    public ResponseEntity<List<NewsResponse>> getListNews() {
        List<NewsResponse> listResponse = getListNews.getListNews();
        return ResponseEntity.ok(listResponse);
    }
}
