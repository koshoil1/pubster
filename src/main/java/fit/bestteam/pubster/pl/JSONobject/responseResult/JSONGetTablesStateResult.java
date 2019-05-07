/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.responseResult;

import fit.bestteam.pubster.pl.JSONobject.common.reservation.JSONTableReservation;
import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetTablesStateResult {
    
    private List<JSONTableReservation> data;

    public JSONGetTablesStateResult() {
    }

    public JSONGetTablesStateResult(List<JSONTableReservation> data) {
        this.data = data;
    }

    public List<JSONTableReservation> getData() {
        return data;
    }

    public void setData(List<JSONTableReservation> data) {
        this.data = data;
    }
    
}
