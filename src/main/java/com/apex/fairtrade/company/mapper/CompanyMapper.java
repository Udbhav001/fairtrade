package com.apex.fairtrade.company.mapper;

import com.apex.fairtrade.company.entity.Company;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class CompanyMapper {

    public Company convert(Map<?, ?> map) {
        Company company = new Company();
        company.setSector(String.valueOf(map.get("Sector")));
        company.setTickerSymbol(String.valueOf(map.get("Symbol")));
        company.setName(String.valueOf(map.get("Name")));
        company.setDescription(String.valueOf(map.get("Description")));
        company.setAddress(String.valueOf(map.get("Address")));
        company.setStockExchange(String.valueOf(map.get("Exchange")));
        company.setIndustry(String.valueOf(map.get("Industry")));
        company.setMarketCap(Long.valueOf((String) map.get("MarketCapitalization")));
        company.setSharesOutstanding(Long.valueOf((String) map.get("SharesOutstanding")));
        return company;
    }
}
