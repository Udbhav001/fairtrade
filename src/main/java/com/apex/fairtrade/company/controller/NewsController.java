package com.apex.fairtrade.company.controller;

import com.apex.fairtrade.company.entity.News;
import com.apex.fairtrade.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newService;

    @GetMapping("/{symbol}")
    public ResponseEntity<News> getNews(@PathVariable String symbol) {
        return new ResponseEntity<>(newService.getNews(symbol), HttpStatus.OK);
    }

    @PostMapping("/{symbol}")
    public ResponseEntity<News> addNews(@PathVariable String symbol) {
        return new ResponseEntity<>(newService.addNews(symbol), HttpStatus.OK);
    }
}
