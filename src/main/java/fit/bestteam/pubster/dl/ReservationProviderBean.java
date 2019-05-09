/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl;

import fit.bestteam.pubster.dl.entity.Boardreservation;
import fit.bestteam.pubster.dl.entity.Reservation;
import fit.bestteam.pubster.dl.service.BoardReservationFacade;
import fit.bestteam.pubster.dl.service.ReservationFacade;
import fit.bestteam.pubster.interfaces.dl.ReservationProvider;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author illia
 */
@Stateless
public class ReservationProviderBean implements ReservationProvider{

    @EJB
    ReservationFacade m_Reservations;
    @EJB
    BoardReservationFacade m_BoardReservations;
    
    @Override
    public List<Reservation> getAll() {
        return m_Reservations.findAll();
    }

    @Override
    public List<Boardreservation> getAllBoardReservations() {
        return m_BoardReservations.findAll();
    }

    @Override
    public List<Boardreservation> getBoardReservations(int boardID) {
        return m_BoardReservations.getByBoardID(boardID);
    }

    @Override
    public Reservation placeReservation(Reservation reservation) {
        m_Reservations.create(reservation);
        return reservation;
    }

}
