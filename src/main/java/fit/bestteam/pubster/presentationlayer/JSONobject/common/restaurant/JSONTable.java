/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.common.restaurant;

/**
 *
 * @author illia
 */
public class JSONTable {
    
    private int id;
    private String info;
    private int capacity;
    private JSONTableView view;

    public JSONTable() {
    }

    public JSONTable(int id, String info, int capacity, JSONTableView view) {
        this.id = id;
        this.info = info;
        this.capacity = capacity;
        this.view = view;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public JSONTableView getView() {
        return view;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setView(JSONTableView view) {
        this.view = view;
    }
    
}
