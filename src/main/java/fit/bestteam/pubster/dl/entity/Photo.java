/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author illia
 */
@Entity
@Table(name = "photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p")
    , @NamedQuery(name = "Photo.findByPhotoid", query = "SELECT p FROM Photo p WHERE p.photoid = :photoid")})
public class Photo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "data")
    private byte[] data;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "photoid")
    private Integer photoid;
    @JoinColumn(name = "restaurantid", referencedColumnName = "restaurantid")
    @ManyToOne(optional = false)
    private Restaurant restaurantid;

    public Photo() {
    }

    public Photo(Integer photoid) {
        this.photoid = photoid;
    }

    public Photo(Integer photoid, byte[] data) {
        this.photoid = photoid;
        this.data = data;
    }


    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public Restaurant getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Restaurant restaurantid) {
        this.restaurantid = restaurantid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photoid != null ? photoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.photoid == null && other.photoid != null) || (this.photoid != null && !this.photoid.equals(other.photoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Photo[ photoid=" + photoid + " ]";
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
}
