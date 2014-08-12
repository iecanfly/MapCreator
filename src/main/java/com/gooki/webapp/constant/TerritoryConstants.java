package com.gooki.webapp.constant;

public enum TerritoryConstants {
    SEPERATOR("\\^"),
	A_BLOCK("block"),
	A_BUILDING("building"),
    IS_DISPLAY_BUS_INFO("isDisplayBusInfo"),
    IS_DISPLAY_BUSINESS_TYPE_INFO("isDisplayBusinessTypeInfo"),
    IS_DISPLAY_COLOUR_DIVISION("isDisplayColourDivision"),
	BLOCK_LIST("blockList"),
	BUILDING_LIST("buildingList"),
    CONGREGATION("cong"),
    CONGREGATION_LIST("congList"),
    ALL_CONGREGATION_LIST("allCongList"),
    ALL_USER_LIST("allUserList"),
    USER_LIST("userList"),
    JSON_OK_RESPONSE("OK"),
    JSON_FAIL_RESPONSE("KO"),
    JSON_NO_PERMISSION_RESPONSE("NO_PERMISSION"), ;

    private String value;
		
	private TerritoryConstants(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
