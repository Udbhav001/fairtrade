package com.apex.fairtrade.company.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "companies")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tickerSymbol;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long sharesOutstanding;

    private String industry;

    @Column(length = 2000)
    private String description;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private DailyPrice price;

    private Long marketCap;

    private String stockExchange;
}
