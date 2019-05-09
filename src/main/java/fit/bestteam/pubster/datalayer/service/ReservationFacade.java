/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer.service;

import fit.bestteam.pubster.datalayer.entity.Reservation;
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
public class ReservationFacade extends AbstractFacade<Reservation>{

    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ReservationFacade() {
        super(Reservation.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
