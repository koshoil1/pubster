/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.businesslayer;

import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONDoReservationData;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONDoReservationResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetActualReservationsResult;
import javax.ejb.Local;

/**
 * Interface with declared Customer API methods
 * @author illia
 */
@Local
public interface CustomerService {
    
    /**
     * JSON-RPC Method DoReservation
     * @param data - JSONDoReservationData parsed from request
     * @return JSONDoReservationResult - jackson compatible API result
     */
    public JSONDoReservationResult DoReservation(JSONDoReservationData data);

    /**
     * JSON-RPC Method GetActualReservations
     * @return JSONGetActualReservationsResult - jackson compatible API result
     */
    public JSONGetActualReservationsResult GetActualReservations();
    
}
