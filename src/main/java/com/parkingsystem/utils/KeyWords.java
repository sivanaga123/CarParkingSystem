package com.parkingsystem.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum KeyWords {
	
	CREATE_PARKING_LOT("create_parking_lot",1),
	PARK("park",2),
	LEAVE("leave",1),
	STATUS("status",0),
	REG_NUM_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour",1),
	SLOT_NUM_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour",1),
	SLOT_NUM_FOR_REG_NUM("slot_number_for_registration_number",1);
	
	private String status;
	private Integer value;
	KeyWords(String status,Integer value){
		this.status = status;
		this.value = value;
	}
	
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
    
    
	public static final Map<KeyWords, Integer> KEYWORDS_MAP;
	static {
		Map<KeyWords,Integer> tmpMap = new HashMap<KeyWords,Integer>();
		for(KeyWords requestStatus : KeyWords.values()) {
            tmpMap.put(requestStatus , requestStatus.value);
        }
		KEYWORDS_MAP = Collections.unmodifiableMap(tmpMap);
	}
}
