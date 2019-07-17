package com.parkingsystem.model;

public class CarDetails {
	private String regNo;
	private String colour;
	
	public CarDetails(String regNo, String colour) {
		this.regNo = regNo;
		this.colour = colour;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "CarDetails [regNo=" + regNo + ", colour=" + colour + "]";
	}
	
}
