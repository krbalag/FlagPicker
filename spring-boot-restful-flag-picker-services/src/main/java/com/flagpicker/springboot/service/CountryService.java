package com.flagpicker.springboot.service;


import java.util.List;

import com.flagpicker.springboot.model.Country;

public interface CountryService {
	
	String findByFlag(String flag);
	
	Country findByName(String name);
	
	void saveCountry(Country country);
	
//	void updateCountry(Country country);
	
	//void deleteCountryByName(String name);

	List<Country> findAllCountries();
	
	void deleteAllCountries();
	
	boolean isCountryExist(Country country);
	
}
