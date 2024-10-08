package com.tlliu.springboot.carolj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tlliu.springboot.carolj.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
    Optional<Country> findByName(@Param("name")String name);
}
