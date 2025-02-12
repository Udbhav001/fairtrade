package com.apex.fairtrade.company.repository;

import com.apex.fairtrade.company.entity.DailyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyPriceRepository extends JpaRepository<DailyPrice, Long> {
    Optional<DailyPrice> findByTickerSymbol(String symbol);
}
