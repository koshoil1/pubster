/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.bl;

import fit.bestteam.pubster.interfaces.bl.UnrestrictedService;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetImageData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetRestaurantFullData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetRestaurantsData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetTablesStateData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetImageResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantFullResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantsResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetTablesStateResult;
import javax.ejb.Stateless;

/**
 *
 * @author illia
 */
@Stateless
public class UnrestrictedServiceBean implements UnrestrictedService{

    @Override
    public JSONGetImageResult GetImage(JSONGetImageData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONGetRestaurantsResult GetRestaurants(JSONGetRestaurantsData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONGetRestaurantFullResult GetRestaurantFull(JSONGetRestaurantFullData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONGetTablesStateResult GetTablesState(JSONGetTablesStateData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
