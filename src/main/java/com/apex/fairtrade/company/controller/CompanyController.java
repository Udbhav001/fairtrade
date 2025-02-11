package com.apex.fairtrade.company.controller;

import com.apex.fairtrade.company.entity.Company;
import com.apex.fairtrade.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/{symbol}")
    public ResponseEntity<Company> addCompanyFromAPI(@PathVariable String symbol) {
        return new ResponseEntity<>(companyService.addCompanyFromAPI(symbol), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<Company> getCompany(@PathVariable String symbol) {
        return new ResponseEntity<>(companyService.getCompany(symbol), HttpStatus.OK);
    }
}
