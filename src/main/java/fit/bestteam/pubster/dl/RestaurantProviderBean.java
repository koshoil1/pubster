/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl;

import fit.bestteam.pubster.dl.entity.Restaurant;
import fit.bestteam.pubster.dl.service.AbstractFacade;
import fit.bestteam.pubster.dl.service.RestaurantFacade;
import fit.bestteam.pubster.interfaces.dl.RestaurantProvider;
import fit.bestteam.pubster.pl.JSONobject.common.google.LatLng;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
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

    @Override
    public List<Restaurant> getAnchored(LatLng anchor, int radius) {
        return getAll();
    }
    
    
    
}
