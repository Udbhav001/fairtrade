package com.apex.fairtrade.company.controller;

import com.apex.fairtrade.company.entity.DailyPrice;
import com.apex.fairtrade.company.service.DailyPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class DailyPriceController {

    @Autowired
    private DailyPriceService dailyPriceService;

    @PostMapping("/refresh/{symbol}")
    public ResponseEntity<DailyPrice> refreshCompanyPrice(@PathVariable String symbol) {
        return new ResponseEntity<>(dailyPriceService.refreshCompanyPrice(symbol), HttpStatus.OK);
    }

    @GetMapping("/refresh/all")
    public void refreshAllCompanyPrice() {
        dailyPriceService.refreshAllCompanyPrices();
    }
}
