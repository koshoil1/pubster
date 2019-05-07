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
public class JSONGetRestaurantFullData {
    
    private int id;

    public JSONGetRestaurantFullData() {
    }

    public JSONGetRestaurantFullData(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
