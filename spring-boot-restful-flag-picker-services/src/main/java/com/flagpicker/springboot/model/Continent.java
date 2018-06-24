package com.flagpicker.springboot.model;

import java.util.List;

public class Continent {

	
	private String name;
	
	private List<Country> countryList;
	
	private long continentId;
	
	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public long getContinentId() {
		return continentId;
	}

	public void setContinentId(long continentId) {
		this.continentId = continentId;
	}

	public Continent(){
		
	}
	
	public Continent( long continentId, String name, List<Country> countryList){
		this.continentId = continentId;
		this.name = name;
		this.countryList = countryList;
	}
	
/*	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
*/
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continent other = (Continent) obj;
		//if (id != other.id)
		//	return false;
		return true;
	}

	@Override
	public String toString() {
		return "Continent [ continentId="+continentId+"name=" + name + ", countryList=" + countryList + "]";
	}


}
