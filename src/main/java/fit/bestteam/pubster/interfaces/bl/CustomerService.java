/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.bl;

import fit.bestteam.pubster.pl.JSONobject.requestData.JSONDoReservationData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONDoReservationResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetActualReservationsResult;
import javax.ejb.Local;

/**
 *
 * @author illia
 */
@Local
public interface CustomerService {
    
    public JSONDoReservationResult DoReservation(JSONDoReservationData data);
    public JSONGetActualReservationsResult GetActualReservations();
    
}
