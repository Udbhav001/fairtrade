package com.apex.fairtrade.company.mapper;

import com.apex.fairtrade.company.entity.DailyPrice;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class DailyPriceMapper {
    public DailyPrice convert(DailyPrice dailyPrice, Map<?, ?> map) {
        if(dailyPrice == null)
            dailyPrice = new DailyPrice();
        Map<?, ?> dailyPriceData = (Map<?, ?>) map.get("Time Series (Daily)");
        Map.Entry<?, ?> entry = dailyPriceData.entrySet().iterator().next();
        Map<?, ?> dailyPriceLatestData = (Map<?, ?>) entry.getValue();
        dailyPrice.setOpenPrice(Double.valueOf((String) dailyPriceLatestData.get("1. open")));
        dailyPrice.setHighestPrice(Double.valueOf((String) dailyPriceLatestData.get("2. high")));
        dailyPrice.setLowestPrice(Double.valueOf((String) dailyPriceLatestData.get("3. low")));
        dailyPrice.setClosingPrice(Double.valueOf((String) dailyPriceLatestData.get("4. close")));
        dailyPrice.setVolume(Long.valueOf((String) dailyPriceLatestData.get("5. volume")));
        return dailyPrice;
    }
}
