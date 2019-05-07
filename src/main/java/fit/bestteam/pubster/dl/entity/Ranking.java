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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author illia
 */
@Entity
@Table(name = "ranking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ranking.findAll", query = "SELECT r FROM Ranking r")
    , @NamedQuery(name = "Ranking.findByRankstars", query = "SELECT r FROM Ranking r WHERE r.rankstars = :rankstars")
    , @NamedQuery(name = "Ranking.findByRanktext", query = "SELECT r FROM Ranking r WHERE r.ranktext = :ranktext")
    , @NamedQuery(name = "Ranking.findByRankingid", query = "SELECT r FROM Ranking r WHERE r.rankingid = :rankingid")})
public class Ranking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rankstars")
    private int rankstars;
    @Size(max = 200)
    @Column(name = "ranktext")
    private String ranktext;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rankingid")
    private Integer rankingid;
    @OneToOne(mappedBy = "rankingid")
    private Reservation reservation;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Ranking() {
    }

    public Ranking(Integer rankingid) {
        this.rankingid = rankingid;
    }

    public Ranking(Integer rankingid, int rankstars) {
        this.rankingid = rankingid;
        this.rankstars = rankstars;
    }

    public int getRankstars() {
        return rankstars;
    }

    public void setRankstars(int rankstars) {
        this.rankstars = rankstars;
    }

    public String getRanktext() {
        return ranktext;
    }

    public void setRanktext(String ranktext) {
        this.ranktext = ranktext;
    }

    public Integer getRankingid() {
        return rankingid;
    }

    public void setRankingid(Integer rankingid) {
        this.rankingid = rankingid;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rankingid != null ? rankingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ranking)) {
            return false;
        }
        Ranking other = (Ranking) object;
        if ((this.rankingid == null && other.rankingid != null) || (this.rankingid != null && !this.rankingid.equals(other.rankingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Ranking[ rankingid=" + rankingid + " ]";
    }
    
}
