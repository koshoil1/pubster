/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.responseResult;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author illia
 */
public class JSONDoRegistrationResult {
    
    public static final String OK = "OK";
    public static final String BADEMAIL = "BADEMAIL";
    public static final String BADPHONE = "BADPHONE";
    public static final String BADLOGIN = "BADLOGIN";
    public static final String BADPASSWORD = "BADPASSWORD";
    public static final String USEDLOGIN = "USEDLOGIN";
    public static final String USEDEMAIL = "USEDEMAIL";
    public static final String USEDPHONE = "USEDPHONE";
    public static final String BADNAME = "BADNAME";
    
    
    private List<String> status;

    public JSONDoRegistrationResult() {
        this.status = new LinkedList<>();
    }

    public JSONDoRegistrationResult(List<String> status) {
        this.status = status;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }
    
    public void addStatus(String status) {
        this.status.add(status);
    }
}
