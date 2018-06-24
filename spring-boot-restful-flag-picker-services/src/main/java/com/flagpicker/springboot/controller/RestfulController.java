package com.flagpicker.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.flagpicker.springboot.model.Continent;
import com.flagpicker.springboot.model.Country;
import com.flagpicker.springboot.service.ContinentService;
import com.flagpicker.springboot.service.CountryService;
import com.flagpicker.springboot.util.ErrorType;

@RestController
@RequestMapping("/")
public class RestfulController {

	@Autowired
	CountryService countryService;
	@Autowired
	ContinentService continentService;

	@RequestMapping(value = "/country/", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> findAllCountries() {
		List<Country> countries = countryService.findAllCountries();
		if (countries.isEmpty()) {
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	@RequestMapping(value = "/continent/", method = RequestMethod.GET)
	public ResponseEntity<List<Continent>> findAllContinents() {
		List<Continent> continents = continentService.findAllContinents();
		if (continents.isEmpty()) {
			return new ResponseEntity<List<Continent>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Continent>>(continents, HttpStatus.OK);
	}
/*	@RequestMapping(value = "/continent/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> findAllCountriesByContinentId(@PathVariable("id") long id)  {
		List<Country> countries = continentService.findAllCountriesByContinentId(id);
		if (countries.isEmpty()) {
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}*/
	@RequestMapping(value = "/continent/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> findAllCountriesByContinentName(@PathVariable("name") String name)  {
		List<Country> countries = continentService.findAllCountriesByContinentName(name);
		if (countries.isEmpty()) {
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
/*	@RequestMapping(value = "/country/{flag}", method = RequestMethod.GET)
	public ResponseEntity<?> findByFlag(@PathVariable("flag") String flag) {
		Country country = countryService.findByFlag(flag);
		if (country == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: flag =" + flag
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
*/
	@RequestMapping(value = "/country/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> findByFlag(@PathVariable("name") String name) {
		String flag = countryService.findByFlag(name);
		/*if (flag == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: name =" + name
					+ " not found"), HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<String>(flag, HttpStatus.OK);
	}

/*	@RequestMapping(value = "/country/", method = RequestMethod.POST)
	public ResponseEntity<?> createCountry(@RequestBody Country country, UriComponentsBuilder ucBuilder) {

		if (countryService.isCountryExist(country)) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: Countryname =" + 
					country.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		countryService.saveCountry(country);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/country/{flag}").buildAndExpand(country.getFlag()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}*/

	/*@RequestMapping(value = "/country/{flag}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCountry(@PathVariable("flag") String flag, @RequestBody Country country) {

		Country currentCountry = countryService.findByFlag(flag);

		if (currentCountry == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: Flag =" + flag + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCountry.setName(country.getName());
		//countryService.u`pdateCountry(currentCountry);
		return new ResponseEntity<Country>(currentCountry, HttpStatus.OK);
	}

	@RequestMapping(value = "/country/{flag}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCountry(@PathVariable("flag") String flag) {

		Country country = countryService.findByFlag(flag);
		if (country == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: Flag =" + flag + " not found."),
					HttpStatus.NOT_FOUND);
		}
		//countryService.deleteCountryById(flag);
		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}*/

/*	@RequestMapping(value = "/country/", method = RequestMethod.DELETE)
	public ResponseEntity<Country> deleteAllCountries() {

		countryService.deleteAllCountries();
		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}*/

}