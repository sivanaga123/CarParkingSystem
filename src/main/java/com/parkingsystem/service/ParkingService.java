package com.parkingsystem.service;

import com.parkingsystem.model.Car;

public interface ParkingService {
	public void createParkingSlots(int noOfSlots);
	public void park(Car carInfo);
	public void leave(String slotNo);
	public void status();
	public void getRegistrationNumbersFromColor(String colour);
	public void getSlotNumbersFromColor(String colour);
	public void getSlotNumberFromRegNo(String regNo);
	public int getMaxSize();
	public int getAvailableSlotListSize();
}
