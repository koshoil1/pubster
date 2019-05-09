/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.responseResult;

import fit.bestteam.pubster.presentationlayer.JSONobject.common.restaurant.JSONRestaurantBrief;
import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetRestaurantsResult {
 
    private List<JSONRestaurantBrief> list;

    public JSONGetRestaurantsResult() {
    }

    public JSONGetRestaurantsResult(List<JSONRestaurantBrief> list) {
        this.list = list;
    }

    public List<JSONRestaurantBrief> getList() {
        return list;
    }

    public void setList(List<JSONRestaurantBrief> list) {
        this.list = list;
    }
  
}
