/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.requestData;

import fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation.JSONReservation;

/**
 *
 * @author illia
 */
public class JSONDoReservationData {
 
    private JSONReservation reservation;

    public JSONDoReservationData() {
    }

    public JSONDoReservationData(JSONReservation reservation) {
        this.reservation = reservation;
    }

    public JSONReservation getReservation() {
        return reservation;
    }

    public void setReservation(JSONReservation reservation) {
        this.reservation = reservation;
    }
    
}
