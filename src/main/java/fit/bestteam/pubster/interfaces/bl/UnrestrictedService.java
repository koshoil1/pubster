/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.bl;

import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetImageData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetRestaurantFullData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetRestaurantsData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetTablesStateData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetImageResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantFullResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantsResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetTablesStateResult;
import javax.ejb.Local;

/**
 *
 * @author illia
 */
@Local
public interface UnrestrictedService {
    
    public JSONGetImageResult GetImage(JSONGetImageData data);
    public JSONGetRestaurantsResult GetRestaurants(JSONGetRestaurantsData data);
    public JSONGetRestaurantFullResult GetRestaurantFull(JSONGetRestaurantFullData data);
    public JSONGetTablesStateResult GetTablesState(JSONGetTablesStateData data);

}
