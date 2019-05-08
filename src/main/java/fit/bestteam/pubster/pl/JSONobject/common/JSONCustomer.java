/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.pl.JSONobject.common;

/**
 *
 * @author illia
 */
public class JSONCustomer {
    
    private String email;
    private String name;
    private int id;
    private String password;
    private String telephone;
    private String login;

    public JSONCustomer() {
    }

    public JSONCustomer(String email, String name, int id, String password, String telephone, String login) {
        this.email = email;
        this.name = name;
        this.id = id;
        this.password = password;
        this.telephone = telephone;
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
