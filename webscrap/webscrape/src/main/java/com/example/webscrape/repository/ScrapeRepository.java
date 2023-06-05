package com.example.webscrape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webscrape.entity.Scrape;

@Repository
public interface ScrapeRepository extends JpaRepository<Scrape, Long>{
    
}
