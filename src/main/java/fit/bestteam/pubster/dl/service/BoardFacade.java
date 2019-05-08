/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.service;

import fit.bestteam.pubster.dl.entity.Board;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author illia
 */
public class BoardFacade extends AbstractFacade<Board> {

    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public BoardFacade() {
        super(Board.class);
    }

    @Override
    public void create(Board entity) {
        super.create(entity);
    }

    public void edit(Integer id, Board entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Board find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<Board> findAll() {
        return super.findAll();
    }

    public List<Board> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
