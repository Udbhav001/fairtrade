package com.apex.fairtrade.investor.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "investors")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=75)
    private String lastName;
    private String email;
    private String phoneNumber;
    @Column(length = 500)
    private String address;
    @Column(length=100)
    private String firstName;


    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Temporal(TemporalType.DATE)
    private Date dateOfAccountOpening;

    @Enumerated(EnumType.STRING)
    private KYCStatus kycStatus;

    private String username;
    private String passwordHash;
    private String securityQuestion;
    private String securityAnswer;

    @Enumerated(EnumType.STRING)
    private RiskToleranceLevel riskToleranceLevel;

//    @ElementCollection
//    @CollectionTable(name = "investor_investment_goals", joinColumns = @JoinColumn(name = "investor_id"))
//    @Column(name = "goal")
//    private List<String> investmentGoals;

//    @ElementCollection
//    @CollectionTable(name = "investor_investment_preferences", joinColumns = @JoinColumn(name = "investor_id"))
//    @Column(name = "preference")
//    private List<String> preferredInvestmentTypes;

    @ElementCollection
    @CollectionTable(name = "investor_preferred_industries", joinColumns = @JoinColumn(name = "investor_id"))
    @Column(name = "industry")
    private List<String> preferredIndustries;

    private Integer totalTrades;
    private BigDecimal averageTradeVolume;

    private BigDecimal netWorth;

    private Boolean emailNotifications;
    private Boolean smsNotifications;



}










