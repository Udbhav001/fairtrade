package com.apex.fairtrade.company.service;

import com.apex.fairtrade.company.entity.Company;
import com.apex.fairtrade.company.mapper.CompanyMapper;
import com.apex.fairtrade.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Value("${company.apiUrl}")
    String apiUrl;

    @Value("${company.apiKey}")
    String apiKey;

    RestClient restClient = RestClient.builder().build();;

    @Autowired
    CompanyMapper companyMapper;

    public Company addCompanyFromAPI(String symbol) {
        Optional<Company> companyFromDB = companyRepository.findByTickerSymbol(symbol);
        if (companyFromDB.isPresent())
            return companyFromDB.get();

        String url = apiUrl + symbol + "&apikey=" + apiKey;

        Map<?, ?> companyMap = restClient.get().uri(url).retrieve().body(Map.class);

        Company company = null;
        if (companyMap != null) {
            company = companyMapper.convert(companyMap);
            companyRepository.save(company);
        }
        return company;
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public Company getCompany(String symbol) {
        Optional<Company> companyFromDB = companyRepository.findByTickerSymbol(symbol);
        return companyFromDB.orElse(null);
    }
}
