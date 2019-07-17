package com.parkingsystem.utils;

public enum KeyWordsEnum {
	
	CREATE_PARKING_LOT("create_parking_lot"),
	PARK("park"),
	LEAVE("leave"),
	STATUS("status"),
	REG_NUM_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour"),
	SLOT_NUM_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour"),
	SLOT_NUM_FOR_REG_NUM("slot_number_for_registration_number");
	
	private String status;
	
	KeyWordsEnum(String status){
		this.status = status;
	}
	
	/*public static final Map<Integer, KeyWordsEnum> KEYWORDS_MAP;
	static {
		Map<Integer, KeyWordsEnum> tmpMap = new HashMap<Integer, KeyWordsEnum>();
		for(KeyWordsEnum requestStatusEnum : KeyWordsEnum.values()) {
            tmpMap.put(requestStatusEnum.status, requestStatusEnum);
        }
		KEYWORDS_MAP = Collections.unmodifiableMap(tmpMap);
	}*/
	
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
