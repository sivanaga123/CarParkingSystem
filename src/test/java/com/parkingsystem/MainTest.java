package com.parkingsystem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.parkingsystem.model.Car;
import com.parkingsystem.service.ParkingService;
import com.parkingsystem.serviceImpl.ParkingServiceImpl;

public class MainTest {
	ParkingService parkingLot = new ParkingServiceImpl();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    
    @Test
    public void createParkingLot() throws Exception {
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        assertEquals(6, parkingLot.getMaxSize());
        assertEquals(6, parkingLot.getAvailableSlotListSize());
        assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
    }

    @Test
    public void park() throws Exception {
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        assertEquals(4, parkingLot.getAvailableSlotListSize());
    }

    @Test
    public void leave() throws Exception {
        parkingLot.leave("2");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.leave("4");
    }

    @Test
    public void status() throws Exception {
        parkingLot.status();
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.status();
    }

    @Test
    public void getRegistrationNumbersFromColor() throws Exception {
        parkingLot.getRegistrationNumbersFromColor("White");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.getRegistrationNumbersFromColor("White");
        parkingLot.getRegistrationNumbersFromColor("Red");
    }

    @Test
    public void getSlotNumbersFromColor() throws Exception {
        parkingLot.getSlotNumbersFromColor("White");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.getSlotNumbersFromColor("White");
        parkingLot.getSlotNumbersFromColor("Red");
    }

    @Test
    public void getSlotNumberFromRegNo() throws Exception {
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-9999");
        parkingLot.leave("1");
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
    }
}
