/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.service;

import fit.bestteam.pubster.dl.entity.Restaurant;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author illia
 */
@Stateless
@LocalBean
public class RestaurantFacade extends AbstractFacade<Restaurant>{
    
    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public RestaurantFacade() {
        super(Restaurant.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
