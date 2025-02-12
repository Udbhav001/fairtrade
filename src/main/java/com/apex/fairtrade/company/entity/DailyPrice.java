package com.apex.fairtrade.company.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tickerSymbol;

    private Double openPrice;

    private Double highestPrice;

    private Double lowestPrice;

    private Double closingPrice;

    private Long volume;
}
