package com.parkingsystem.model;

public class CarDetails {
	private Integer slotNo;
	private String regNo;
	private String colour;
	
	public CarDetails(Integer slotNo, String regNo, String colour) {
		super();
		this.slotNo = slotNo;
		this.regNo = regNo;
		this.colour = colour;
	}

	public Integer getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
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
		return "CarDetails [slotNo=" + slotNo + ", regNo=" + regNo + ", colour=" + colour + "]";
	}
	
}
