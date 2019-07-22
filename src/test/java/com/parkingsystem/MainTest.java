package com.parkingsystem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.parkingsystem.model.Car;
import com.parkingsystem.service.ParkingService;
import com.parkingsystem.serviceImpl.ParkingServiceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MainTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
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
        assertEquals(6, parkingLot.MAX_SIZE);
        assertEquals(6, parkingLot.availableSlotList.size());
        assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
    }

    @Test
    public void park() throws Exception {
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        assertEquals(4, parkingLot.availableSlotList.size());
    }

    @Test
    public void leave() throws Exception {
        parkingLot.leave("2");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.leave("4");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "Slotnumber4isalreadyempty", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void status() throws Exception {
        parkingLot.status();
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.status();
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "SlotNo.\tRegistrationNo.\tColor\n" +
                "1\tKA-01-HH-1234\tWhite\n" +
                "2\tKA-01-HH-9999\tWhite", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void getRegistrationNumbersFromColor() throws Exception {
        parkingLot.getRegistrationNumbersFromColor("White");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.getRegistrationNumbersFromColor("White");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999", outContent.toString().trim().replace(" ", ""));
        parkingLot.getRegistrationNumbersFromColor("Red");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999Notfound", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void getSlotNumbersFromColor() throws Exception {
        parkingLot.getSlotNumbersFromColor("White");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.getSlotNumbersFromColor("White");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2", outContent.toString().trim().replace(" ", ""));
        parkingLot.getSlotNumbersFromColor("Red");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void getSlotNumberFromRegNo() throws Exception {
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
        parkingLot.createParkingSlots(Integer.parseInt("6"));
        parkingLot.park(new Car("KA-01-HH-1234", "White"));
        parkingLot.park(new Car("KA-01-HH-9999", "White"));
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1", outContent.toString().trim().replace(" ", ""));
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-9999");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2", outContent.toString().trim().replace(" ", ""));
        parkingLot.leave("1");
        parkingLot.getSlotNumberFromRegNo("KA-01-HH-1234");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2\n" +
                "Slotnumber1isfree\n" +
                "\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }
}
