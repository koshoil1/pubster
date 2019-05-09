/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.responseResult;

import fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation.JSONReservation;
import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetActualReservationsResult {
    
    private List<JSONReservation> list;

    public JSONGetActualReservationsResult() {
    }

    public JSONGetActualReservationsResult(List<JSONReservation> list) {
        this.list = list;
    }

    public List<JSONReservation> getList() {
        return list;
    }

    public void setList(List<JSONReservation> list) {
        this.list = list;
    }
    
}
