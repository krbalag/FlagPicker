package com.flagpicker.springboot.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Continents;
import com.flagpicker.springboot.model.Country;
import com.flagpicker.springboot.repository.ContinentRepository;

public interface ContinentService {
	
	
	
	Continent findByName(String name);
	
	void saveContinent(List<Continent> continents);

	List<Continent> findAllContinents();

	List<Country> findAllCountriesByContinentId(long continentId);
	List<Country> findAllCountriesByContinentName(String continentName);
	
	void deleteAllContinents();
	
	boolean isContinentExist(Continent continent);
	



/*    private ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public Iterable<Continents> list() {
        return continentRepository.findAll();
    }

    public Continents save(Continents continents) {
        return continentRepository.save(continents);
    }

    public void save(List<Continents> continents) {
    	continentRepository.save(continents);
    }
*/
	}
