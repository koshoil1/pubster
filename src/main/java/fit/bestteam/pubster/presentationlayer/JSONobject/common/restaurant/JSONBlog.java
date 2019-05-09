/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.common.restaurant;

/**
 *
 * @author illia
 */
public class JSONBlog {
 
    private int id;
    private long date;
    private String HTMLText;

    public JSONBlog() {
    }

    public JSONBlog(int id, long date, String HTMLText) {
        this.id = id;
        this.date = date;
        this.HTMLText = HTMLText;
    }

    public long getDate() {
        return date;
    }

    public String getHTMLText() {
        return HTMLText;
    }

    public int getId() {
        return id;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setHTMLText(String HTMLText) {
        this.HTMLText = HTMLText;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
