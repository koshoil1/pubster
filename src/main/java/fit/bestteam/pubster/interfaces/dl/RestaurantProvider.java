/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.dl;

import fit.bestteam.pubster.dl.entity.Restaurant;
import java.util.List;

/**
 *
 * @author illia
 */
public interface RestaurantProvider {
    
    public List<Restaurant> getAll();
    public Restaurant getById(int ID);
    
}
