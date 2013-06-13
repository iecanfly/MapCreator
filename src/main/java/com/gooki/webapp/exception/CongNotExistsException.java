package com.gooki.webapp.exception;

public final class CongNotExistsException extends Exception {
	private static final long serialVersionUID = 3278647818245199636L;

    private String cong;

    public CongNotExistsException(String cong) {
        this.cong = cong;
    }

    public String getCong() {
        return cong;
    }
}
