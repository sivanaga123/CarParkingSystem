package com.parkingsystem.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.parkingsystem.model.Car;
import com.parkingsystem.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {
	public int MAX_SIZE = 0;
	
    public ArrayList<Integer> availableSlotList; // Available slots list
    Map<String, Car> map1; // Map of Slot, Car
    Map<String, String> map2;  // Map of RegNo, Slot
    Map<String, ArrayList<String>> map3;  // Map of Color, List of RegNo
    
	@Override
	public void createParkingSlots(int noOfSlots) {
		try {
            this.MAX_SIZE = noOfSlots;
        } catch (Exception e) {
            System.out.println("Invalid lot count");
            System.out.println();
        }
        this.availableSlotList = new ArrayList<Integer>() {};
        for (int i=1; i<= this.MAX_SIZE; i++) {
            availableSlotList.add(i);
        }
        this.map1 = new HashMap<String, Car>();
        this.map2 = new HashMap<String, String>();
        this.map3 = new HashMap<String, ArrayList<String>>();
        System.out.println("Created parking lot with " + noOfSlots + " slots");
        System.out.println();
    }
	
	public void park(Car carInfo) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() == this.MAX_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            this.map1.put(slot, carInfo);
            this.map2.put(carInfo.getRegNo(), slot);
            if (this.map3.containsKey(carInfo.getColour())) {
                ArrayList<String> regNoList = this.map3.get(carInfo.getColour());
                this.map3.remove(carInfo.getColour());
                regNoList.add(carInfo.getRegNo());
                this.map3.put(carInfo.getColour(), regNoList);
            } else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(carInfo.getRegNo());
                this.map3.put(carInfo.getColour(), regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
	
	public void leave(String slotNo) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
            Car carInfo = this.map1.get(slotNo);
            if (carInfo != null) {
                this.map1.remove(slotNo);
                this.map2.remove(carInfo.getRegNo());
                ArrayList<String> regNoList = this.map3.get(carInfo.getColour());
                if (regNoList.contains(carInfo.getRegNo())) {
                    regNoList.remove(carInfo.getRegNo());
                }
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
	
	public void status() {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColor");
            Car carInfo;
            for (int i = 1; i <= this.MAX_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.map1.containsKey(key)) {
                	carInfo = this.map1.get(key);
                    System.out.println(i + "\t" + carInfo.getRegNo() + "\t\t" + carInfo.getColour());
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
	
	public void getRegistrationNumbersFromColor(String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map3.containsKey(color)) {
            ArrayList<String> regNoList = this.map3.get(color);
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
	
	public void getSlotNumbersFromColor(String color) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map3.containsKey(color)) {
            ArrayList<String> regNoList = this.map3.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(this.map2.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    public void getSlotNumberFromRegNo(String regNo) {
        if (this.MAX_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map2.containsKey(regNo)) {
            System.out.println(this.map2.get(regNo));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
	
}
