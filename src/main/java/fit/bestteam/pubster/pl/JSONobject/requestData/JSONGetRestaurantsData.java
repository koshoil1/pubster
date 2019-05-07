/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.requestData;

import fit.bestteam.pubster.pl.JSONobject.common.google.LatLng;

/**
 *
 * @author illia
 */
public class JSONGetRestaurantsData {
    
    private LatLng position;
    private int radius;

    public JSONGetRestaurantsData() {
    }

    public JSONGetRestaurantsData(LatLng position, int radius) {
        this.position = position;
        this.radius = radius;
    }

    public LatLng getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}
