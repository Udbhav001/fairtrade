package com.apex.fairtrade.company.repository;

import com.apex.fairtrade.company.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    Optional<News> findByTickerSymbol(String symbol);
}
