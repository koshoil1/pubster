/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.bl;

import fit.bestteam.pubster.dl.entity.Customer;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONDoReservationData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONDoReservationResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetActualReservationsResult;

/**
 *
 * @author illia
 */
public interface CustomerService {
    
    public JSONDoReservationResult DoReservation(int customerID, JSONDoReservationData data);
    public JSONGetActualReservationsResult GetActualReservations(int customerID);
    
}
