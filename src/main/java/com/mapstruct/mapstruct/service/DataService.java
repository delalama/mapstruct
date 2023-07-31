package com.mapstruct.mapstruct.service;

import com.mapstruct.mapstruct.model.Company;
import com.mapstruct.mapstruct.model.CompanyDTO;
import com.mapstruct.mapstruct.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    CompanyRepository dataRepository;

    public long saveOrUpdate(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setName(companyDTO.getName());

        Company savedCompany = dataRepository.save(company);
        return savedCompany.getId();
    }

}
