/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.datalayer;

import fit.bestteam.pubster.datalayer.entity.Boardreservation;
import fit.bestteam.pubster.datalayer.entity.Reservation;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface for Beans, declares necessary methods for accessing Reservation objects
 * @author illia
 */
@Local
public interface ReservationProvider {
    
    public List<Reservation> getAll();

    public List<Boardreservation> getAllBoardReservations();

    /**
     * Returns all reservations on certain Table
     * @param boardID
     * @return List of found Reservations
     */
    public List<Boardreservation> getBoardReservations(int boardID);

    public Reservation placeReservation(Reservation reservation);
    
}
