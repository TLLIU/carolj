package com.tlliu.springboot.carolj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlliu.springboot.carolj.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}
