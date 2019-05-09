/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "boardreservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boardreservation.findAll", query = "SELECT b FROM Boardreservation b")
    , @NamedQuery(name = "Boardreservation.findByNumberofseats", query = "SELECT b FROM Boardreservation b WHERE b.numberofseats = :numberofseats")
    , @NamedQuery(name = "Boardreservation.findByTablereservationid", query = "SELECT b FROM Boardreservation b WHERE b.tablereservationid = :tablereservationid")})
public class Boardreservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberofseats")
    private int numberofseats;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tablereservationid")
    private Integer tablereservationid;
    @JoinColumn(name = "tableid", referencedColumnName = "boardid")
    @ManyToOne(optional = false)
    private Board tableid;
    @JoinColumn(name = "reservationid", referencedColumnName = "reservationid")
    @ManyToOne(optional = false)
    private Reservation reservationid;

    public Boardreservation() {
    }

    public Boardreservation(Integer tablereservationid) {
        this.tablereservationid = tablereservationid;
    }

    public Boardreservation(Integer tablereservationid, int numberofseats) {
        this.tablereservationid = tablereservationid;
        this.numberofseats = numberofseats;
    }

    public int getNumberofseats() {
        return numberofseats;
    }

    public void setNumberofseats(int numberofseats) {
        this.numberofseats = numberofseats;
    }

    public Integer getTablereservationid() {
        return tablereservationid;
    }

    public void setTablereservationid(Integer tablereservationid) {
        this.tablereservationid = tablereservationid;
    }

    public Board getTableid() {
        return tableid;
    }

    public void setTableid(Board tableid) {
        this.tableid = tableid;
    }

    public Reservation getReservationid() {
        return reservationid;
    }

    public void setReservationid(Reservation reservationid) {
        this.reservationid = reservationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablereservationid != null ? tablereservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boardreservation)) {
            return false;
        }
        Boardreservation other = (Boardreservation) object;
        if ((this.tablereservationid == null && other.tablereservationid != null) || (this.tablereservationid != null && !this.tablereservationid.equals(other.tablereservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Boardreservation[ tablereservationid=" + tablereservationid + " ]";
    }
    
}
