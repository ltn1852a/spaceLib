package com.j2e.exceptions;


public class userAlreadyExistsException extends Exception{

 public userAlreadyExistsException(){
     super("utilisateur existe déja");
 } 
    public userAlreadyExistsException(String msg) {
        super(msg);
    }

}
