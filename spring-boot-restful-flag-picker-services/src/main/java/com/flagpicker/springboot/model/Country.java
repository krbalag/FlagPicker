package com.flagpicker.springboot.model;
	
public class Country {

	private long continentId;
	
	private String name;
	
	private String  flag;
	
	public Country(){
		//id=0;
	}
	
	public Country(long continentId, String flag, String name){
		this.continentId = continentId;
		this.name = name;
		this.flag = flag;
	}
	
	public long getcontinentId() {
		return continentId;
	}

	public void setcontinentId(long continentId) {
		this.continentId = continentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

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
		Country other = (Country) obj;
		if (flag != other.flag)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [continentId=" + continentId + ", name=" + name + ", flag=" + flag + "]";
	}


}
