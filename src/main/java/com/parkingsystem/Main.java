package com.parkingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.parkingsystem.process.AbstractParkingProcess;
import com.parkingsystem.process.ParkingProcess;
import com.parkingsystem.service.InputValidationService;
import com.parkingsystem.serviceImpl.InputValidationServiceImpl;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "*** Welcome to Car Parking System ***" );
		String inputLine;
		BufferedReader bufferReader;
		InputValidationService inputValidationService = new InputValidationServiceImpl();
		AbstractParkingProcess parkingProcess = new ParkingProcess();
		
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
							if (inputValidationService.isValidInput(inputLine))
							{
								parkingProcess.processImplementation(inputLine);
							}else {
								System.out.println("Not valid command");
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
				try(BufferedReader fileReader = new BufferedReader(new FileReader(new File(args[0]))))
				{
					while ((inputLine = fileReader.readLine().trim()) != null)
					{
						if (inputValidationService.isValidInput(inputLine))
						{	
							parkingProcess.processImplementation(inputLine.trim());
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
