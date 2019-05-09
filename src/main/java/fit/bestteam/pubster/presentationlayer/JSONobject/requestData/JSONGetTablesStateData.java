/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.requestData;

import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetTablesStateData {
 
    private List<Integer> tableIDs;
    private long since;
    private int duration;

    public JSONGetTablesStateData() {
    }

    public JSONGetTablesStateData(List<Integer> tableIDs, long since, int duration) {
        this.tableIDs = tableIDs;
        this.since = since;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public long getSince() {
        return since;
    }

    public List<Integer> getTableIDs() {
        return tableIDs;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSince(long since) {
        this.since = since;
    }

    public void setTableIDs(List<Integer> tableIDs) {
        this.tableIDs = tableIDs;
    }
}
