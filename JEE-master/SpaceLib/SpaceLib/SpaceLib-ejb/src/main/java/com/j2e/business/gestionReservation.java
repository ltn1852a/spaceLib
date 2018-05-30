
import javax.ejb.Stateless;

@Stateless
public class gestionReservation implements gestionResaLocal{

    @Override
    public int[] reserverVoyage(int nbVoyageurs, int idstatArriv) throws navettesNotAvailableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reserverQuaiDest(int idStationDest) throws quaisNotAvailableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
