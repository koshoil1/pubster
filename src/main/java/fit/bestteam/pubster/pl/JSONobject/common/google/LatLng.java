/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.common.google;

/**
 *
 * @author illia
 */
public class LatLng {
    
    private float lat;
    private float lng;
    private String formatted_address;

    public LatLng() {
    }

    public LatLng(float lat, float lng, String formatted_address) {
        this.lat = lat;
        this.lng = lng;
        this.formatted_address = formatted_address;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
    
    
            
    
}
