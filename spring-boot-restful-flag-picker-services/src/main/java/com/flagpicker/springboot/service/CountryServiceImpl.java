package com.flagpicker.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.flagpicker.springboot.model.Country;



@Service("countryService")
public class CountryServiceImpl implements CountryService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Country> countries;
	
	static{
		makeDummyData();
	}

	public List<Country> findAllCountries() {
		return countries;
	}
	
	public String findByFlag(String name) {
		for(Country country : countries){
			
			if(country.getName().equalsIgnoreCase(name)){
				System.out.println("in findbyflag"+country.getFlag());
				return country.getFlag();
			}
		}
		return null;
	}
	
	public Country  findByName(String name) {
		for(Country country : countries){
			if(country.getName().equalsIgnoreCase(name)){
				return country;
			}
		}
		return null;
	}
	
	public void saveCountry(Country country) {
		country.setFlag("🇺🇸");
		countries.add(country);
	}




	public boolean isCountryExist(Country country) {
		return findByName(country.getName())!=null;
	}
	
	public void deleteAllCountries(){
		countries.clear();
	}

	private static void makeDummyData(){
		List<Country> countryList = new ArrayList<Country>();
		countryList.add(new Country(1,"🇳🇬","Nigeria"));
		countryList.add(new Country(1,"🇪🇹","Ethiopia"));
		countryList.add(new Country(1,"🇪🇬","Egypt"));
		countryList.add(new Country(1,"🇳🇨","DR Congo"));
		countryList.add(new Country(1,"🇿🇦","South Africa"));
		
		countryList.add(new Country(2,"🇺🇸","USA"));
		countryList.add(new Country(2,"🇧🇷","Brazil"));
		countryList.add(new Country(2,"🇲🇽","Mexico"));
		countryList.add(new Country(2,"🇨🇴","Colombia"));
		countryList.add(new Country(2,"🇦🇷","Argentina"));
		
		countryList.add(new Country(3,"🇨🇳","China"));
		countryList.add(new Country(3,"🇮🇳","India"));
		countryList.add(new Country(3,"🇮🇩","Indonesia"));
		countryList.add(new Country(3,"🇵🇰","Pakistan"));
		countryList.add(new Country(3,"🇧🇩","Bangladesh"));
		
		countryList.add(new Country(4,"🇷🇺","Russia"));
		countryList.add(new Country(4,"🇩🇪","Germany"));
		countryList.add(new Country(4,"🇬🇧","UK"));
		countryList.add(new Country(4,"🇬🇧","France"));
		countryList.add(new Country(4,"🇮🇹","Italy"));
		
		countryList.add(new Country(5,"🇦🇺","Australia"));
		countryList.add(new Country(5,"🇵🇬","Papua New Guinea"));
		countryList.add(new Country(5,"🇳🇿","New Zealand"));
		countryList.add(new Country(5,"🇫🇯","Fiji"));
		countryList.add(new Country(5,"🇸🇧","Solomon Islands"));
		
		countries = countryList;
	}

}
