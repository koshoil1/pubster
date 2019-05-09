/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.datalayer;

import fit.bestteam.pubster.datalayer.entity.Restaurant;
import fit.bestteam.pubster.presentationlayer.JSONobject.common.google.LatLng;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author illia
 */
@Local
public interface RestaurantProvider {
    
    public List<Restaurant> getAll();
    public List<Restaurant> getAnchored(LatLng anchor, int radius);
    public Restaurant getById(int ID);
    
}