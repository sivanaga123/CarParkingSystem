package com.parkingsystem.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum KeyWordsEnum {
	CREATE_PARKING_LOT(1,"create_parking_lot"),
	PARK(2,"park"),
	LEAVE(3,"leave"),
	STATUS(4,"status"),
	REG_NUM_FOR_CARS_WITH_COLOUR(5,"registration_numbers_for_cars_with_colour"),
	SLOT_NUM_FOR_CARS_WITH_COLOUR(6,"slot_numbers_for_cars_with_colour"),
	SLOT_NUM_FOR_REG_NUM(7,"slot_number_for_registration_number");
	
	private Integer status;
	private String value;
	KeyWordsEnum(Integer status, String value){
		this.status = status;
		this.value = value;
	}
	
	public static final Map<Integer, KeyWordsEnum> KEYWORDS_MAP;
	static {
		Map<Integer, KeyWordsEnum> tmpMap = new HashMap<Integer, KeyWordsEnum>();
		for(KeyWordsEnum requestStatusEnum : KeyWordsEnum.values()) {
            tmpMap.put(requestStatusEnum.status, requestStatusEnum);
        }
		KEYWORDS_MAP = Collections.unmodifiableMap(tmpMap);
	}
	
	public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
