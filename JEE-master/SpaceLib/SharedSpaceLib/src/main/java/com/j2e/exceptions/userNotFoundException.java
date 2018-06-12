package com.j2e.exceptions;


public class userNotFoundException extends Exception{

	public userNotFoundException(){

		super("Utilisateur non connu");
	}
	public userNotFoundException(String msg){
		super(msg);
	}
}
