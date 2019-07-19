package com.parkingsystem.process;

import com.parkingsystem.model.Car;
import com.parkingsystem.service.ParkingService;
import com.parkingsystem.serviceImpl.ParkingServiceImpl;
import com.parkingsystem.utils.CommandKeyWords;

public class ParkingProcess implements AbstractParkingProcess {
	ParkingService parkingService = new ParkingServiceImpl();
	
	public void processImplementation(String inputString) {
		int level =1;
		String[] commandWords = inputString.split(" ");
		
		switch (commandWords[0])
		{
			case CommandKeyWords.CREATE_PARKING_LOT :
					try{
						parkingService.createParkingSlots(Integer.parseInt(commandWords[1]));
					} catch(Exception e) {
						
					}
				break;
			case CommandKeyWords.PARK :
					parkingService.park(new Car(commandWords[1], commandWords[2]));
				break;
			case CommandKeyWords.LEAVE:
					try{
						parkingService.leave(commandWords[1]);
					} catch(Exception e){
						
					}
				break;
			case CommandKeyWords.STATUS :
					parkingService.status();
				break;
			case CommandKeyWords.REG_NUM_FOR_CARS_WITH_COLOUR :
					parkingService.getRegistrationNumbersFromColor(commandWords[1]);
				break;
			case CommandKeyWords.SLOT_NUM_FOR_CARS_WITH_COLOUR :
				parkingService.getSlotNumbersFromColor(commandWords[1]);
				break;
			case CommandKeyWords.SLOT_NUM_FOR_REG_NUM :
				parkingService.getSlotNumberFromRegNo(commandWords[1]);
				break;
			default:
				break;
		}
	}
}
