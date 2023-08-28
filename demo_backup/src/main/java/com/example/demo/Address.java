package com.example.demo;

public class Address {
	private int zipCode;
	private String city;
	private String country;
	
	public Address(int zipCode, String city, String country) {
		// super();		// 상속받은 것이 없어서 삭제
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Zip Code=" + zipCode + ", City=" + city + ", Country=" + country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
