package com.gooki.webapp.constant;

public enum TerritoryConstants {
    SEPERATOR("\\^"),
	A_BLOCK("block"),
	BLOCK_LIST("blockList"),
    CONGREGATION("cong"),
    CONGREGATION_LIST("congList"),
    JSON_OK_RESPONSE("OK"),
    JSON_FAIL_RESPONSE("KO")
    ;
		
	String value;
	
	private TerritoryConstants(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
