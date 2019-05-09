/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.businesslayer;

import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONGetOngoingReservationsData;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetOngoingReservationsResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetRestaurantFullResult;
import javax.ejb.Local;

/**
 * Interface with declared Staff API methods
 * @author illia
 */
@Local
public interface StaffService {
    
    /**
     * JSON-RPC Method GetOngoingReservations
     * returns all reservations somehow actual at given time interval
     * parsed from JSONGetOngoingReservationsData
     * @param data - JSONGetOngoingReservationsData parsed from request
     * @return JSONGetOngoingReservationsResult - jackson compatible API result
     */
    public JSONGetOngoingReservationsResult
                GetOngoingReservations(JSONGetOngoingReservationsData data);

    /**
     * JSON-RPC Method GetRestaurant, returns full info about linked Restaurant
     * @return JSONGetRestaurantFullResult - jackson compatible API result
     */
    public JSONGetRestaurantFullResult GetRestaurant();
    
}
