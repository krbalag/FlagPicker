package com.flagpicker.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Country;


@Service("continentService")
public class ContinentServiceImpl implements ContinentService{


	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Continent> continents;
	
	static{
		makeDummyData();
	}

	public List<Continent> findAllContinents() {
		return this.continents;
	}
	
	public Continent findByFlag(String flag) {
		for(Continent continent : continents){
			/*if(continent.getFlag() == flag){
				return continent;
			}*/
		}
		return null;
	}
	
	public Continent  findByName(String name) {
		for(Continent continent : continents){
			if(continent.getName().equalsIgnoreCase(name)){
				return continent;
			}
		}
		return null;
	}
	
	public void addCountry(Continent continent) {
		continents.add(continent);
	}

/*	public boolean isContinentExist(Continent continent) {
		return findByName(continent.getName())!=null;
	}*/
	
	public void deleteAllContinent(){
		continents.clear();
	}

	private static void makeDummyData(){
		List<Country> africaCountryList = new ArrayList<Country>();
		List<Country> usaCountryList = new ArrayList<Country>();
		List<Country> asiaCountryList = new ArrayList<Country>();
		List<Country> europeCountryList = new ArrayList<Country>();
		List<Country> oceaniaCountryList = new ArrayList<Country>();
		
		africaCountryList.add(new Country(1,"🇳🇬","Nigeria"));
		africaCountryList.add(new Country(1,"🇪🇹","Ethiopia"));
		africaCountryList.add(new Country(1,"🇪🇬","Egypt"));
		africaCountryList.add(new Country(1,"🇳🇨","DR Congo"));
		africaCountryList.add(new Country(1,"🇿🇦","South Africa"));
		
		usaCountryList.add(new Country(2,"🇺🇸","USA"));
		usaCountryList.add(new Country(2,"🇧🇷","Brazil"));
		usaCountryList.add(new Country(2,"🇲🇽","Mexico"));
		usaCountryList.add(new Country(2,"🇨🇴","Colombia"));
		usaCountryList.add(new Country(2,"🇦🇷","Argentina"));
		
		asiaCountryList.add(new Country(3,"🇨🇳","China"));
		asiaCountryList.add(new Country(3,"🇮🇳","India"));
		asiaCountryList.add(new Country(3,"🇮🇩","Indonesia"));
		asiaCountryList.add(new Country(3,"🇵🇰","Pakistan"));
		asiaCountryList.add(new Country(3,"🇧🇩","Bangladesh"));
		
		europeCountryList.add(new Country(4,"🇷🇺","Russia"));
		europeCountryList.add(new Country(4,"🇩🇪","Germany"));
		europeCountryList.add(new Country(4,"🇬🇧","UK"));
		europeCountryList.add(new Country(4,"🇬🇧","France"));
		europeCountryList.add(new Country(4,"🇮🇹","Italy"));
		
		oceaniaCountryList.add(new Country(5,"🇦🇺","Australia"));
		oceaniaCountryList.add(new Country(5,"🇵🇬","Papua New Guinea"));
		oceaniaCountryList.add(new Country(5,"🇳🇿","New Zealand"));
		oceaniaCountryList.add(new Country(5,"🇫🇯","Fiji"));
		oceaniaCountryList.add(new Country(5,"🇸🇧","Solomon Islands"));
		List<Continent> continentList = new ArrayList<Continent>();
		continentList.add(new Continent(1,"Africa",africaCountryList));
		continentList.add(new Continent(2,"America",usaCountryList));
		continentList.add(new Continent(3,"Asia",asiaCountryList));
		continentList.add(new Continent(4,"Europe",europeCountryList));
		continentList.add(new Continent(5,"Oceania",oceaniaCountryList));

		continents = continentList;
	}
	


	public void saveContinent(List<Continent> continents) {
		// TODO Auto-generated method stub
		System.out.println("continents list "+continents);
		this.continents = continents;
		
	}


	@Override
	public void deleteAllContinents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isContinentExist(Continent continent) {
		// TODO Auto-generated method stub
		return false;
	}


/*	public List<Country> findAllCountriesByContinentId(long continentId) {
		for(Continent continent:continents ){
			if(continent.getContinentId()==continentId) {
		//	   System.out.println(continent.getCountryList());
				return continent.getCountryList();
			}
		}
		return null;
	}*/

	public List<Country> findAllCountriesByContinentName(String name) {
		for(Continent continent:continents ){
			if(continent.getName().equalsIgnoreCase(name)) {
			  // System.out.println(continent.getCountryList());
				return continent.getCountryList();
			}
		}
		return null;
	}
/* public static void main(String args[]) {
	  ContinentServiceImpl cc = new ContinentServiceImpl();
	  cc.findAllCountriesByContinentName("America");
  }
*/
	@Override
	public List<Country> findAllCountriesByContinentId(long continentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
