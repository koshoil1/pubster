/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl;

import fit.bestteam.pubster.dl.entity.Restaurant;
import fit.bestteam.pubster.dl.service.AbstractFacade;
import fit.bestteam.pubster.interfaces.dl.RestaurantProvider;
import fit.bestteam.pubster.pl.JSONobject.common.google.LatLng;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author illia
 */
@Stateless
public class RestaurantProviderBean extends AbstractFacade<Restaurant> implements RestaurantProvider{

    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public RestaurantProviderBean() {
        super(Restaurant.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Restaurant> getAll() {
        return super.findAll();
    }

    @Override
    public Restaurant getById(int ID) {
        return super.find(ID);
    }

    @Override
    public List<Restaurant> getAnchored(LatLng anchor, int radius) {
        return getAll();
    }
    
    
    
}
