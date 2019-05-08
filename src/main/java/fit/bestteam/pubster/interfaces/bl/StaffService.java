/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.bl;

import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetOngoingReservationsData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetOngoingReservationsResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantFullResult;
import javax.ejb.Local;

/**
 *
 * @author illia
 */
@Local
public interface StaffService {
    
    public JSONGetOngoingReservationsResult
                GetOngoingReservations(JSONGetOngoingReservationsData data);
    public JSONGetRestaurantFullResult GetRestaurant();
    
}
