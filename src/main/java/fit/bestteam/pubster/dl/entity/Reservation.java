/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author illia
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByCreationdate", query = "SELECT r FROM Reservation r WHERE r.creationdate = :creationdate")
    , @NamedQuery(name = "Reservation.findByComment", query = "SELECT r FROM Reservation r WHERE r.comment = :comment")
    , @NamedQuery(name = "Reservation.findBySince", query = "SELECT r FROM Reservation r WHERE r.since = :since")
    , @NamedQuery(name = "Reservation.findByState", query = "SELECT r FROM Reservation r WHERE r.state = :state")
    , @NamedQuery(name = "Reservation.findByDurationmin", query = "SELECT r FROM Reservation r WHERE r.durationmin = :durationmin")
    , @NamedQuery(name = "Reservation.findByReservationid", query = "SELECT r FROM Reservation r WHERE r.reservationid = :reservationid")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Size(max = 200)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "since")
    @Temporal(TemporalType.TIMESTAMP)
    private Date since;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "durationmin")
    private int durationmin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservationid")
    private Integer reservationid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationid")
    private List<Boardreservation> boardreservationList;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne
    private Customer customerid;
    @JoinColumn(name = "rankingid", referencedColumnName = "rankingid")
    @OneToOne
    private Ranking rankingid;

    public Reservation() {
    }

    public Reservation(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Reservation(Integer reservationid, Date creationdate, Date since, int state, int durationmin) {
        this.reservationid = reservationid;
        this.creationdate = creationdate;
        this.since = since;
        this.state = state;
        this.durationmin = durationmin;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDurationmin() {
        return durationmin;
    }

    public void setDurationmin(int durationmin) {
        this.durationmin = durationmin;
    }

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
    }

    @XmlTransient
    public List<Boardreservation> getBoardreservationList() {
        return boardreservationList;
    }

    public void setBoardreservationList(List<Boardreservation> boardreservationList) {
        this.boardreservationList = boardreservationList;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Ranking getRankingid() {
        return rankingid;
    }

    public void setRankingid(Ranking rankingid) {
        this.rankingid = rankingid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationid != null ? reservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationid == null && other.reservationid != null) || (this.reservationid != null && !this.reservationid.equals(other.reservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Reservation[ reservationid=" + reservationid + " ]";
    }
    
}
