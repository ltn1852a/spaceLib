package com.j2e.exceptions;


public class navettesNotAvailableException extends Exception {

	public navettesNotAvailableException(){
		super("Navette non dispo");
	}

    public navettesNotAvailableException(String msg) {
        super(msg);
    }

}

