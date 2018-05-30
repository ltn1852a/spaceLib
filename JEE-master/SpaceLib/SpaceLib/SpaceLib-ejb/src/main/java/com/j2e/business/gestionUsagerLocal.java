package com.j2e.business;


import javax.ejb.Local;

@Local
public interface gestionUsagerLocal {
	
public usager addUsager(int idUser, string psw) throws userAlreadyExistsException;
public usager identify(int iduser, String psw) throws userNotFoundException;

}
