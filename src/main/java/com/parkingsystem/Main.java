package com.parkingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.parkingsystem.process.ParkingProcess;
import com.parkingsystem.service.InputValidationService;
import com.parkingsystem.service.ParkingService;
import com.parkingsystem.serviceImpl.InputValidationServiceImpl;
import com.parkingsystem.serviceImpl.ParkingServiceImpl;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "*** Welcome to Car Parking System ***" );
		String inputLine;
		BufferedReader bufferReader;
		InputValidationService inputValidationService = new InputValidationServiceImpl();
		ParkingProcess parkingProcess = new ParkingProcess();
		
        switch (args.length)
		{
			case 0:
			{
				System.out.println("Please Enter the your input:");
				while (true)
				{
					try
					{
						bufferReader = new BufferedReader(new InputStreamReader(System.in));
						inputLine = bufferReader.readLine().trim();
						
						if (inputLine.equalsIgnoreCase("Exit"))
						{
							break;
						}
						else
						{
							System.out.println(inputLine);
							if (inputValidationService.isValidInput(inputLine))
							{
								System.out.println(inputLine);
								parkingProcess.processImplementation(inputLine);
							}
						}
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
				}
				break;
			}
			case 1:
			{
				try(BufferedReader fileReader = new BufferedReader(new FileReader(new File(args[0]))) )
				{
					while ((inputLine = fileReader.readLine()) != null)
					{
						inputLine = inputLine.trim();
						if (inputValidationService.isValidInput(inputLine))
						{
							
						}
					}
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				break;
			}
			default:
				System.out.println("Invalid Input");
		}
		        
    }
}
