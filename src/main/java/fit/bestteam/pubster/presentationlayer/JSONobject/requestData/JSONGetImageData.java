/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.requestData;

import java.util.List;

/**
 *
 * @author illia
 */
public class JSONGetImageData {
    
    private List<Integer> ids;

    public JSONGetImageData() {
    }

    public JSONGetImageData(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    
}
