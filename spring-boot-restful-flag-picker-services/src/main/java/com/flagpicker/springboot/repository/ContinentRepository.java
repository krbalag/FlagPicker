package com.flagpicker.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.flagpicker.springboot.model.Continent;

//import org.springframework.data.repository.CrudRepository;

import com.flagpicker.springboot.model.Continents;


	public interface ContinentRepository extends CrudRepository<Continents, Long> {
}