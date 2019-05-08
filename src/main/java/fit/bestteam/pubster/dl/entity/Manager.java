/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author illia
 */
@Entity
@Table(name = "manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m")
    , @NamedQuery(name = "Manager.findByEmail", query = "SELECT m FROM Manager m WHERE m.email = :email")
    , @NamedQuery(name = "Manager.findByPassword", query = "SELECT m FROM Manager m WHERE m.password = :password")
    , @NamedQuery(name = "Manager.findByLogin", query = "SELECT m FROM Manager m WHERE m.login = :login")
    , @NamedQuery(name = "Manager.findByTelephone", query = "SELECT m FROM Manager m WHERE m.telephone = :telephone")
    , @NamedQuery(name = "Manager.findByManagerid", query = "SELECT m FROM Manager m WHERE m.managerid = :managerid")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telephone")
    private String telephone;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "managerid")
    private Integer managerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerid")
    private List<Restaurant> restaurantList;

    public Manager() {
    }

    public Manager(Integer managerid) {
        this.managerid = managerid;
    }

    public Manager(Integer managerid, String email, String password, String login, String telephone) {
        this.managerid = managerid;
        this.email = email;
        this.password = password;
        this.login = login;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    @XmlTransient
    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerid != null ? managerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.managerid == null && other.managerid != null) || (this.managerid != null && !this.managerid.equals(other.managerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Manager[ managerid=" + managerid + " ]";
    }
    
}
