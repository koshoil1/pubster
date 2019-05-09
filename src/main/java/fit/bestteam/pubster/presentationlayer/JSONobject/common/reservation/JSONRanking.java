/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation;

/**
 *
 * @author illia
 */
public class JSONRanking {
    
    private int id;
    private int stars;
    private String text;

    public JSONRanking() {
    }

    public JSONRanking(int id, int stars, String text) {
        this.id = id;
        this.stars = stars;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getStars() {
        return stars;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
