/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer.entity;

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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressline", query = "SELECT a FROM Address a WHERE a.addressline = :addressline")
    , @NamedQuery(name = "Address.findByLat", query = "SELECT a FROM Address a WHERE a.lat = :lat")
    , @NamedQuery(name = "Address.findByLng", query = "SELECT a FROM Address a WHERE a.lng = :lng")
    , @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "addressline")
    private String addressline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lat")
    private float lat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lng")
    private float lng;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressid")
    private Integer addressid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressid")
    private List<Restaurant> restaurantList;

    public Address() {
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Address(Integer addressid, String addressline, float lat, float lng) {
        this.addressid = addressid;
        this.addressline = addressline;
        this.lat = lat;
        this.lng = lng;
    }

    public String getAddressline() {
        return addressline;
    }

    public void setAddressline(String addressline) {
        this.addressline = addressline;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
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
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Address[ addressid=" + addressid + " ]";
    }
    
}
