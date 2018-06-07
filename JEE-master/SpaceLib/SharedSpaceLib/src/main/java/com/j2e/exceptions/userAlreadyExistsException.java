package com.j2e.exceptions;


public class userAlreadyExistsException extends Exception{

	public userAlreadyExistsException(){
		super();
	}

    public userAlreadyExistsException(String msg) {
        super(msg);
    }

}
