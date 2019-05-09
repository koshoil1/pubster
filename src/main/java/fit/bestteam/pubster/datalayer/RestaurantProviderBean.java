/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer;

import fit.bestteam.pubster.datalayer.entity.Restaurant;
import fit.bestteam.pubster.datalayer.service.RestaurantFacade;
import fit.bestteam.pubster.interfaces.datalayer.RestaurantProvider;
import fit.bestteam.pubster.presentationlayer.JSONobject.common.google.LatLng;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * RestaurantProvider implementation
 * Local Stateless Bean to provide access to Restaurant objects
 * @author illia
 */
@Stateless
public class RestaurantProviderBean implements RestaurantProvider{

    @EJB
    RestaurantFacade m_Restaurants;

    @Override
    public List<Restaurant> getAll() {
        return m_Restaurants.findAll();
    }

    @Override
    public Restaurant getById(int ID) {
        return m_Restaurants.find(ID);
    }

    /**
     * Filters Restaurants near to Anchor
     * @param anchor
     * @param radius
     * @return List of found Restaurants
     */
    @Override
    public List<Restaurant> getAnchored(LatLng anchor, int radius) {
        return getAll();
    }
    
    
    
}
