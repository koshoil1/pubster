/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.bl;

import fit.bestteam.pubster.interfaces.bl.CustomerService;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONDoReservationData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONDoReservationResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetActualReservationsResult;
import javax.ejb.Stateless;

/**
 *
 * @author illia
 */
@Stateless
public class CustomerServiceBean implements CustomerService{

    @Override
    public JSONDoReservationResult DoReservation(JSONDoReservationData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONGetActualReservationsResult GetActualReservations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
