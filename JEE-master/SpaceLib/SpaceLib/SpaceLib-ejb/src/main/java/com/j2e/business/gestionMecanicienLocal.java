package com.j2e.business;


import javax.ejb.Local;

@Local
public interface gestionMecanicienLocal {

	//public void identifyMeca(int idMeca, String psw, int idStation) throws stationNotFoundException, usagerNotFoundException, wrongStationForMecaException;
	public int[] navettesAreviser(int idStation);
	
	//au choix de la navette (alé de la liste int[] navettesAreviser, ça return le numéro de quai ou se trouve cette navette
	public int chooseNavette(int[] navettes);
}
