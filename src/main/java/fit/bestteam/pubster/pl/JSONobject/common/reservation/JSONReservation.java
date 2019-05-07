/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.common.reservation;

import java.util.List;

/**
 *
 * @author illia
 */
public class JSONReservation {
    
    private int id;
    private long created;
    private String comment;
    private long since;
    private int duration;
    private String state;
    private JSONRanking ranking;
    private List<JSONTableReservation> tables;

    public JSONReservation() {
    }

    public JSONReservation(int id, long created, String comment, long since,
            int duration, String state, JSONRanking ranking, List<JSONTableReservation> tables) {
        this.id = id;
        this.created = created;
        this.comment = comment;
        this.since = since;
        this.duration = duration;
        this.state = state;
        this.ranking = ranking;
        this.tables = tables;
    }

    public String getComment() {
        return comment;
    }

    public long getCreated() {
        return created;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public JSONRanking getRanking() {
        return ranking;
    }

    public long getSince() {
        return since;
    }

    public String getState() {
        return state;
    }

    public List<JSONTableReservation> getTables() {
        return tables;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRanking(JSONRanking ranking) {
        this.ranking = ranking;
    }

    public void setSince(long since) {
        this.since = since;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTables(List<JSONTableReservation> tables) {
        this.tables = tables;
    }
    
}
