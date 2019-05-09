/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.businesslayer;

import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONDoRegistrationData;
import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONGetImageData;
import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONGetRestaurantFullData;
import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONGetRestaurantsData;
import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONGetTablesStateData;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONDoRegistrationResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetImageResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetRestaurantFullResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetRestaurantsResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetTablesStateResult;
import javax.ejb.Local;

/**
 * Interface with declared Unrestricted API methods
 * @author illia
 */
@Local
public interface UnrestrictedService {
    
    /**
     * JSON-RPC Method DoRegistration, register new Customer
     * @param data - JSONDoRegistrationData parsed from request
     * @return JSONDoRegistrationResult - jackson compatible API result
     * @throws Exception
     */
    public JSONDoRegistrationResult DoRegistration(JSONDoRegistrationData data) throws Exception;
    
    /**
     * JSON-RPC Method GetImage, returns Base64 encode Image
     * in JSONGetImageResult
     * @param data - JSONGetImageData parsed from request
     * @return JSONGetImageResult - jackson compatible API result
     */
    public JSONGetImageResult GetImage(JSONGetImageData data);

    /**
     * JSON-RPC Method GetRestaurants,
     * returns filtered by anchor+radius Restaurants
     * @param data - JSONGetRestaurantsData parsed from request
     * @return JSONGetRestaurantsResult - jackson compatible API result
     */
    public JSONGetRestaurantsResult GetRestaurants(JSONGetRestaurantsData data);

    /**
     * JSON-RPC Method GetRestaurantFull,
     * uses restaurantID from JSONGetRestaurantFullData
     * @param data - JSONGetRestaurantFullData parsed from request
     * @return JSONGetRestaurantFullResult - jackson compatible API result
     */
    public JSONGetRestaurantFullResult GetRestaurantFull(JSONGetRestaurantFullData data);

    /**
     * JSON-RPC Method GetTablesState,
     * returns information about free seats at tables,
     * which ids are in JSONGetTablesStateData
     * @param data - JSONGetTablesStateData parsed from request
     * @return JSONGetTablesStateResult - jackson compatible API result
     */
    public JSONGetTablesStateResult GetTablesState(JSONGetTablesStateData data);

}
