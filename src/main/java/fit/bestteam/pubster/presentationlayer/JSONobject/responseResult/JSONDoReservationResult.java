/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.responseResult;

import fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation.JSONReservation;

/**
 *
 * @author illia
 */
public class JSONDoReservationResult {
    
    private JSONReservation reservation;

    public JSONDoReservationResult() {
    }

    public JSONDoReservationResult(JSONReservation reservation) {
        this.reservation = reservation;
    }

    public JSONReservation getReservation() {
        return reservation;
    }

    public void setReservation(JSONReservation reservation) {
        this.reservation = reservation;
    }
    
}
