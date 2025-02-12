package com.apex.fairtrade.investor.controller;

import com.apex.fairtrade.investor.entity.Investor;
import com.apex.fairtrade.investor.entity.InvestorDTO;
import com.apex.fairtrade.investor.service.InvestorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investor")
public class InvestorController {

    @Autowired
    InvestorService investorService;

    @PostMapping
    public ResponseEntity<Investor> createInvestor(@RequestBody @Valid InvestorDTO investorDTO) {
        return new ResponseEntity<>(investorService.createInvestor(investorDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Investor> getInvestor(@PathVariable Long id) {
        return new ResponseEntity<>(investorService.getInvestor(id), HttpStatus.OK);
    }
}
