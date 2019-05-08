/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.service;

import fit.bestteam.pubster.dl.entity.Blog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author illia
 */
public class BlogFacade extends AbstractFacade<Blog> {

    @PersistenceContext(unitName = "fit.bestteam_pubster_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public BlogFacade() {
        super(Blog.class);
    }

    @Override
    public void create(Blog entity) {
        super.create(entity);
    }

    public void edit(Integer id, Blog entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Blog find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<Blog> findAll() {
        return super.findAll();
    }

    public List<Blog> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
