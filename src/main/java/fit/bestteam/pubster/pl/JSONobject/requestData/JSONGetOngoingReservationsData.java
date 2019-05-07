/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.requestData;

/**
 *
 * @author illia
 */
public class JSONGetOngoingReservationsData {
    
    private long since;
    private int period;

    public JSONGetOngoingReservationsData() {
    }

    public JSONGetOngoingReservationsData(long since, int period) {
        this.since = since;
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public long getSince() {
        return since;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setSince(long since) {
        this.since = since;
    }
    
}
