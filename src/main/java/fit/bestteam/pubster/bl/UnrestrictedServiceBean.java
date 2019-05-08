/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.bl;

import fit.bestteam.pubster.dl.entity.Blog;
import fit.bestteam.pubster.dl.entity.Board;
import fit.bestteam.pubster.dl.entity.Photo;
import fit.bestteam.pubster.dl.entity.Restaurant;
import fit.bestteam.pubster.interfaces.bl.UnrestrictedService;
import fit.bestteam.pubster.interfaces.dl.RestaurantProvider;
import fit.bestteam.pubster.pl.JSONobject.common.google.LatLng;
import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONBlog;
import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONPhoto;
import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONRestaurantBrief;
import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONRestaurantFull;
import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONTable;
import fit.bestteam.pubster.pl.JSONobject.common.restaurant.JSONTableView;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetImageData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetRestaurantFullData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetRestaurantsData;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONGetTablesStateData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetImageResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantFullResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetRestaurantsResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetTablesStateResult;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author illia
 */
@Stateless
public class UnrestrictedServiceBean implements UnrestrictedService{

    @EJB
    RestaurantProvider m_Provider;
    
    @Override
    public JSONGetImageResult GetImage(JSONGetImageData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONGetRestaurantsResult GetRestaurants(JSONGetRestaurantsData data) {
        List<Restaurant> v_all = m_Provider.getAnchored(data.getPosition(), data.getRadius());
        List<JSONRestaurantBrief> v_list = new LinkedList<>();
        
        for (Restaurant next : v_all) {
            JSONRestaurantBrief v_restaurant = new JSONRestaurantBrief();
            v_restaurant.setDescription(next.getDescription());
            v_restaurant.setEmail(next.getEmail());
            v_restaurant.setId(next.getRestaurantid());
            v_restaurant.setWebAddress(next.getWebaddress());
            v_restaurant.setTelephone(next.getTelephone());
            v_restaurant.setAddress(
                    new LatLng(next.getAddressid().getLat(),
                            next.getAddressid().getLng(),
                            next.getAddressid().getAddressline()));
            v_restaurant.setName(next.getName());
            v_restaurant.setRating(next.getRating());
            v_list.add(v_restaurant);
        }
        return new JSONGetRestaurantsResult(v_list);
    }

    @Override
    public JSONGetRestaurantFullResult GetRestaurantFull(JSONGetRestaurantFullData data) {
        JSONRestaurantFull v_res = new JSONRestaurantFull();
        
        Restaurant v_one = m_Provider.getById(data.getRestaurantID());
        JSONRestaurantBrief v_restaurant = new JSONRestaurantBrief();
        v_restaurant.setDescription(v_one.getDescription());
        v_restaurant.setEmail(v_one.getEmail());
        v_restaurant.setId(v_one.getRestaurantid());
        v_restaurant.setWebAddress(v_one.getWebaddress());
        v_restaurant.setTelephone(v_one.getTelephone());
        v_restaurant.setAddress(
                new LatLng(v_one.getAddressid().getLat(),
                        v_one.getAddressid().getLng(),
                        v_one.getAddressid().getAddressline()));
        v_restaurant.setName(v_one.getName());
        v_restaurant.setRating(v_one.getRating());
        v_res.setInfo(v_restaurant);
        
        List<JSONBlog> v_blog = new LinkedList<>();
        for (Blog next : v_one.getBlogList()){
            v_blog.add(new JSONBlog(next.getBlogid(),
                            next.getDate().getTime(), next.getHtmltext()));
        }
        v_res.setBlog(v_blog);
        
        List<JSONPhoto> v_photos = new LinkedList<>();
        for (Photo next : v_one.getPhotoList()){
            v_photos.add(new JSONPhoto(next.getPhotoid()));
        }
        v_res.setPhotos(v_photos);
        
        List<JSONTable> v_tables = new LinkedList<>();
        for (Board next : v_one.getBoardList()){
            v_tables.add(new JSONTable(next.getBoardid(),
                     next.getTableinformation(), next.getCapacity(),
                        new JSONTableView(next.getBoardviewList().get(0).getType())));
        }
        v_res.setTables(v_tables);
        
        return new JSONGetRestaurantFullResult(v_res);
    }

    @Override
    public JSONGetTablesStateResult GetTablesState(JSONGetTablesStateData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
