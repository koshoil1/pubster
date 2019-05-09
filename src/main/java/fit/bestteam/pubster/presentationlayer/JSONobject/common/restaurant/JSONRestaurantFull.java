/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.common.restaurant;

import java.util.List;

/**
 *
 * @author illia
 */
public class JSONRestaurantFull {
    
    private JSONRestaurantBrief info;
    private List<JSONBlog> blog;
    private List<JSONPhoto> photos;
    private List<JSONTable> tables;

    public JSONRestaurantFull() {
    }

    public JSONRestaurantFull(JSONRestaurantBrief info, List<JSONBlog> blog,
            List<JSONPhoto> photos, List<JSONTable> tables) {
        this.info = info;
        this.blog = blog;
        this.photos = photos;
        this.tables = tables;
    }

    public List<JSONBlog> getBlog() {
        return blog;
    }

    public JSONRestaurantBrief getInfo() {
        return info;
    }

    public List<JSONPhoto> getPhotos() {
        return photos;
    }

    public List<JSONTable> getTables() {
        return tables;
    }

    public void setBlog(List<JSONBlog> blog) {
        this.blog = blog;
    }

    public void setInfo(JSONRestaurantBrief info) {
        this.info = info;
    }

    public void setPhotos(List<JSONPhoto> photos) {
        this.photos = photos;
    }

    public void setTables(List<JSONTable> tables) {
        this.tables = tables;
    }
    
}
