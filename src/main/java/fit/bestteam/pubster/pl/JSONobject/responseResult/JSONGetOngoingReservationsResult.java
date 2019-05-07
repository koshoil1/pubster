/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.responseResult;

import fit.bestteam.pubster.pl.JSONobject.common.reservation.JSONReservation;
import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetOngoingReservationsResult {
    
    private List<JSONReservation> list;

    public JSONGetOngoingReservationsResult() {
    }

    public JSONGetOngoingReservationsResult(List<JSONReservation> list) {
        this.list = list;
    }

    public List<JSONReservation> getList() {
        return list;
    }

    public void setList(List<JSONReservation> list) {
        this.list = list;
    }
    
}
