package com.parkingsystem.serviceImpl;

import com.parkingsystem.service.InputValidationService;
import com.parkingsystem.utils.KeyWords;

public class InputValidationServiceImpl implements InputValidationService {
	
	@Override
	public Boolean isValidInput(String inputString) {
		String inputWords[] = inputString.split(" ");
		boolean isValidString = false;
		try
		{
			int mapValue = KeyWords.KEYWORDS_MAP.get(KeyWords.valueOf(inputWords[0].toUpperCase()));
			switch (inputWords.length)
			{
				case 1:
					if (mapValue == 0)
						isValidString = true;
					break;
				case 2:
					if (mapValue == 1)
						isValidString = true;
					break;
				case 3:
					if (mapValue == 2)
						isValidString = true;
					break;
				default:
					isValidString = false;
			}
		}catch(Exception e) {
			isValidString = false;
		}
		
		return isValidString;
	}
	
}
