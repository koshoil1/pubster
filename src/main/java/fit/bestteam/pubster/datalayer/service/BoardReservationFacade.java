/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer.service;

import fit.bestteam.pubster.datalayer.entity.Boardreservation;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author illia
 */
@Stateless
@LocalBean
public class BoardReservationFacade extends AbstractFacade<Boardreservation>{
    
    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public BoardReservationFacade() {
        super(Boardreservation.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public List<Boardreservation> getByBoardID(int id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Boardreservation> query = builder.createQuery(Boardreservation.class);
        Root<Boardreservation> root = query.from(Boardreservation.class);
        query.select(root).where(builder.equal(root.join("tableid").get("boardid"), id));
        return getEntityManager().createQuery(query).getResultList();
    }
}
