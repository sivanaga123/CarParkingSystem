package com.parkingsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "*** Car Parking System ***" );
        BufferedReader bufferReader = null;
		String input = null;
		
        switch (args.length)
		{
			case 0:
			{
				System.out.println("Input:");
				while (true)
				{
					try
					{
						bufferReader = new BufferedReader(new InputStreamReader(System.in));
						input = bufferReader.readLine().trim();
						if (input.equalsIgnoreCase("exit"))
						{
							break;
						}
						else
						{
							/*if (processor.validate(input))
							{
								try
								{
									processor.execute(input.trim());
								}
								catch (Exception e)
								{
									System.out.println(e.getMessage());
								}
							}
							else
							{
								printUsage();
							}*/
						}
					}
					catch (Exception e)
					{
						
					}
				}
				break;
			}
			case 1:
			{
				File inputFile = new File(args[0]);
				try
				{
					bufferReader = new BufferedReader(new FileReader(inputFile));
					while ((input = bufferReader.readLine()) != null)
					{
						input = input.trim();
						
					}
				}
				catch (Exception e)
				{
					
				}
				break;
			}
			default:
				System.out.println("Invalid input.");
		}
		        
    }
}
