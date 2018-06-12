package com.j2e.exceptions;


public class userNotFoundException extends Exception{

	public userNotFoundException(){
		super("utilisateur introuvable");
	}
	public userNotFoundException(String msg){
		super(msg);
	}
}
