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
    
    private int restaurantID;

    public JSONGetRestaurantFullData() {
    }

    public JSONGetRestaurantFullData(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
    
}
