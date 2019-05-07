/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.responseResult;

import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONRestaurantFull;

/**
 *
 * @author illia
 */
public class JSONGetRestaurantFullResult {
    
    private JSONRestaurantFull restaurant;

    public JSONGetRestaurantFullResult() {
    }

    public JSONGetRestaurantFullResult(JSONRestaurantFull restaurant) {
        this.restaurant = restaurant;
    }

    public JSONRestaurantFull getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(JSONRestaurantFull restaurant) {
        this.restaurant = restaurant;
    }
    
}
