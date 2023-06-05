package com.example.webscrape.service;

import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.example.webscrape.entity.Scrape;
import com.example.webscrape.repository.ScrapeRepository;

@Service
public class ScrapeService {

    private final ScrapeRepository scrapeRepository;

    public ScrapeService(ScrapeRepository scrapeRepository) {
        this.scrapeRepository = scrapeRepository;
    }
    
    public Scrape scrapeWebsite(String url) {
        
        try {
            
            Document doc = Jsoup.connect(url).get();

            String title = doc.title();

            Scrape sd = new Scrape();

            sd.setLink(url);
            sd.setTitle(title);
            sd.setTime(System.currentTimeMillis());

            
            return scrapeRepository.save(sd);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Scrape> getAllScrapes() {
        return scrapeRepository.findAll();
    }

    public Optional<Scrape> getScrapeById(Long id) {
        return scrapeRepository.findById(id);
    }
}
