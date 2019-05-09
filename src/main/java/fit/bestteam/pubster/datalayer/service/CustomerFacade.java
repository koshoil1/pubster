/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer.service;

import fit.bestteam.pubster.datalayer.entity.Boardreservation;
import fit.bestteam.pubster.datalayer.entity.Customer;
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
public class CustomerFacade extends AbstractFacade<Customer>{
    
    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public boolean checkIdentificator(String id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root).where(builder.or(builder.equal(root.get("email"), id),
                builder.equal(root.get("login"), id),
                builder.equal(root.get("telephone"), id)));
        
        List<Customer> v_list = getEntityManager().createQuery(query).getResultList();
        return v_list.isEmpty();
    }
    
    public Customer getByIdentificator(String id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root).where(builder.or(builder.equal(root.get("email"), id),
                builder.equal(root.get("login"), id),
                builder.equal(root.get("telephone"), id)));
        return getEntityManager().createQuery(query).getSingleResult();
    }
    
}
