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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByLogin", query = "SELECT c FROM Customer c WHERE c.login = :login")
    , @NamedQuery(name = "Customer.findByTelephone", query = "SELECT c FROM Customer c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
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
    @Column(name = "name")
    private String name;
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
    @Column(name = "customerid")
    private Integer customerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Notification> notificationList;
    @OneToMany(mappedBy = "customerid")
    private List<Reservation> reservationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Ranking> rankingList;

    public Customer() {
    }

    public Customer(Integer customerid) {
        this.customerid = customerid;
    }

    public Customer(Integer customerid, String password, String name, String login, String telephone) {
        this.customerid = customerid;
        this.password = password;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @XmlTransient
    public List<Ranking> getRankingList() {
        return rankingList;
    }

    public void setRankingList(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Customer[ customerid=" + customerid + " ]";
    }
    
}
