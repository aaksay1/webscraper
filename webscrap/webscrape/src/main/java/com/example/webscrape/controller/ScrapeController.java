package com.example.webscrape.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webscrape.service.ScrapeService;
import com.example.webscrape.entity.Scrape;

@RestController
@RequestMapping("/kaboom")
public class ScrapeController {

    private final ScrapeService scrapeService;

    public ScrapeController(ScrapeService scrapeService) {
        this.scrapeService = scrapeService;
    }

    @PostMapping("/scrap")
    public ResponseEntity<Void> createScrape(@RequestBody Map<String, String> request) {
        String url = request.get("url");
        scrapeService.scrapeWebsite(url);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Scrape>> getAllScrapes() {
        List<Scrape> scrapes = scrapeService.getAllScrapes();
        return ResponseEntity.ok(scrapes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Scrape> getScrapeById(@PathVariable Long id) {
        Optional<Scrape> scrape = scrapeService.getScrapeById(id);
        return scrape.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
