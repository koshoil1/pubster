/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.dl;

import fit.bestteam.pubster.dl.entity.Boardreservation;
import fit.bestteam.pubster.dl.entity.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author illia
 */
@Local
public interface ReservationProvider {
    
    public List<Reservation> getAll();
    public List<Boardreservation> getAllBoardReservations();
    public List<Boardreservation> getBoardReservations(int boardID);
    
}
