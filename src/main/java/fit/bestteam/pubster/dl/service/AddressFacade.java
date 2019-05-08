/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.service;

import fit.bestteam.pubster.dl.entity.Address;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author illia
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {

    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public AddressFacade() {
        super(Address.class);
    }

    @Override
    public void create(Address entity) {
        super.create(entity);
    }

    public void edit(Integer id, Address entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Address find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<Address> findAll() {
        return super.findAll();
    }

    public List<Address> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
