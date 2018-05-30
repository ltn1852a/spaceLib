

@Local
public interface gestionResaLocal {

	//return le numero du quai départ et le numéro de quai arrivée (on peut faire un systemOut aussi)
 public int[] reserverVoyage(int nbVoyageurs, int idstatArriv) throws navettesNotAvailableException;
 public void reserverQuaiDest(int idStationDest) throws quaisNotAvailableException;
}
