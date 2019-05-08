/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.common.restaurant;

import fit.bestteam.pubster.pl.JSONobject.common.google.LatLng;

/**
 *
 * @author illia
 */
public class JSONRestaurantBrief {
    
    private int id;
    private String name;
    private String description;
    private String webAddress;
    private String email;
    private String telephone;
    private LatLng address;
    private float rating;

    public JSONRestaurantBrief() {
    }

    public JSONRestaurantBrief(int id, String name, String description,
            String webAddress, String email, String telephone, LatLng address, float rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.webAddress = webAddress;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.rating = rating;
    }

    public LatLng getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setAddress(LatLng address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }
    
}
