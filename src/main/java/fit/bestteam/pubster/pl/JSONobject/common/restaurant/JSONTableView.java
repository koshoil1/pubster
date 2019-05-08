/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.common.restaurant;

/**
 *
 * @author illia
 */
public final class JSONTableView {
    
    private String type;

    public JSONTableView() {
    }

    public JSONTableView(String type) {
        this.type = type;
    }
    
    public JSONTableView(int type) {
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void setType(int type) {
        switch (type) {
            case 0: this.type = "SQUARE"; break;
            case 1: this.type = "ROUND"; break;
            default: this.type = "SQUARE"; break;
        }
    }
    
}
