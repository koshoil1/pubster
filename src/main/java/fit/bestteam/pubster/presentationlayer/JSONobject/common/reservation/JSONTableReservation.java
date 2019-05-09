/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation;

/**
 *
 * @author illia
 */
public class JSONTableReservation {
    
    private int id;
    private int tableID;
    private int seats;

    public JSONTableReservation() {
    }

    public JSONTableReservation(int id, int tableID, int seats) {
        this.id = id;
        this.tableID = tableID;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public int getTableID() {
        return tableID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }
    
}
