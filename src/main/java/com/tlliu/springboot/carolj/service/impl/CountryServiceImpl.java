package com.tlliu.springboot.carolj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlliu.springboot.carolj.model.Country;
import com.tlliu.springboot.carolj.repository.CountryRepository;
import com.tlliu.springboot.carolj.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepo;

    @Override
    public List<Country> getCountries() {
        return countryRepo.findAll();
    }

    @Override
    public Country getCountry(Integer id) {
        return countryRepo.findById(id).orElse(null);
    }

    @Override
    public Country getCountryByName(String countryName) {
        return countryRepo.findByName(countryName).orElse(null);
    }
    
}
