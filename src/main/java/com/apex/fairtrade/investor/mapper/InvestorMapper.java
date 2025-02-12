package com.apex.fairtrade.investor.mapper;

import com.apex.fairtrade.investor.entity.Investor;
import com.apex.fairtrade.investor.entity.InvestorDTO;
import org.springframework.stereotype.Component;

@Component
public class InvestorMapper {

    public Investor convert(InvestorDTO investorDTO) {
        Investor investor = new Investor();
        investor.setFirstName(investorDTO.getFirstName());
        investor.setLastName(investorDTO.getLastName());
        investor.setEmail(investorDTO.getEmail());
        investor.setPhoneNumber(investorDTO.getPhoneNumber());
        investor.setAccountType(investorDTO.getAccountType());
        investor.setUsername(investorDTO.getUserName());
        return investor;
    }
}
