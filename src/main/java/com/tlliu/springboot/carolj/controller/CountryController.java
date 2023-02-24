package com.tlliu.springboot.carolj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlliu.springboot.carolj.model.Country;
import com.tlliu.springboot.carolj.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
