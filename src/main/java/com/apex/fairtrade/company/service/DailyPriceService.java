package com.apex.fairtrade.company.service;

import com.apex.fairtrade.company.entity.DailyPrice;
import com.apex.fairtrade.company.mapper.DailyPriceMapper;
import com.apex.fairtrade.company.repository.DailyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DailyPriceService {

    @Autowired
    DailyPriceMapper dailyPriceMapper;

    @Value("${company.price.apiUrl}")
    String apiUrl;

    @Value("${company.price.apiKey}")
    String apiKey;

    RestClient restClient = RestClient.builder().build();

    @Autowired
    DailyPriceRepository dailyPriceRepository;

    public DailyPrice refreshCompanyPrice(String symbol) {
        Optional<DailyPrice> optionalDailyPrice = dailyPriceRepository.findByTickerSymbol(symbol);
        DailyPrice dailyPriceFromDB = null;
        if(optionalDailyPrice.isPresent())
            dailyPriceFromDB = optionalDailyPrice.get();
        String url = apiUrl + symbol + "&apikey=" + apiKey;

        Map<?, ?> dailyPriceMap = restClient.get().uri(url).retrieve().body(Map.class);
        DailyPrice dailyPrice = null;
        if (dailyPriceMap != null) {
            dailyPrice = dailyPriceMapper.convert(dailyPriceFromDB, dailyPriceMap);
            dailyPrice.setTickerSymbol(symbol);
            dailyPriceRepository.save(dailyPrice);
        }
        return dailyPrice;
    }

    @Scheduled(initialDelay = 1000)
    public void refreshAllCompanyPrices() {
        List<DailyPrice> allPrices = dailyPriceRepository.findAll();
        for(DailyPrice dailyPrice: allPrices) {
            refreshCompanyPrice(dailyPrice.getTickerSymbol());
        }
    }
}
