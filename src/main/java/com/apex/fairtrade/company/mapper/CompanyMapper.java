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
        return company;
    }
}
