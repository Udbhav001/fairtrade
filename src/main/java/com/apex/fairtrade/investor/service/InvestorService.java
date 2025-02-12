package com.apex.fairtrade.investor.service;

import com.apex.fairtrade.investor.entity.Investor;
import com.apex.fairtrade.investor.entity.InvestorDTO;
import com.apex.fairtrade.investor.mapper.InvestorMapper;
import com.apex.fairtrade.investor.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    InvestorMapper investorMapper;

    public Investor createInvestor(InvestorDTO investorDTO) {
        Investor investor = investorMapper.convert(investorDTO);
        return investorRepository.save(investor);
    }

    public Investor getInvestor(Long id) {
        Optional<Investor> investor = investorRepository.findById(id);
        return investor.orElse(null);
    }
}
