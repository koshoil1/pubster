/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer.JSONobject.requestData;

import fit.bestteam.pubster.presentationlayer.JSONobject.common.JSONCustomer;

/**
 *
 * @author illia
 */
public class JSONDoRegistrationData {
    
    private JSONCustomer account;

    public JSONDoRegistrationData() {
    }

    public JSONDoRegistrationData(JSONCustomer account) {
        this.account = account;
    }

    public JSONCustomer getAccount() {
        return account;
    }

    public void setAccount(JSONCustomer account) {
        this.account = account;
    }
    
}
