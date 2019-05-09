/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.responseResult;

import fit.bestteam.pubster.presentationlayer.JSONobject.common.JSONImage;
import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetImageResult {
 
    private List<JSONImage> images;

    public JSONGetImageResult() {
    }

    public JSONGetImageResult(List<JSONImage> images) {
        this.images = images;
    }

    public List<JSONImage> getImages() {
        return images;
    }

    public void setImages(List<JSONImage> images) {
        this.images = images;
    }
    
}
