package com.tlliu.springboot.carolj.service;

import java.util.List;

import com.tlliu.springboot.carolj.model.Country;

public interface CountryService {
    public List<Country> getCountries();
    public Country getCountry(Integer id);
}
