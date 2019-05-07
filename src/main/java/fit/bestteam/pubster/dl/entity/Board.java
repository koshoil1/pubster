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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "board")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Board.findAll", query = "SELECT b FROM Board b")
    , @NamedQuery(name = "Board.findByTableinformation", query = "SELECT b FROM Board b WHERE b.tableinformation = :tableinformation")
    , @NamedQuery(name = "Board.findByBoardid", query = "SELECT b FROM Board b WHERE b.boardid = :boardid")
    , @NamedQuery(name = "Board.findByCapacity", query = "SELECT b FROM Board b WHERE b.capacity = :capacity")})
public class Board implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "tableinformation")
    private String tableinformation;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "boardid")
    private Integer boardid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableid")
    private List<Boardreservation> boardreservationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boardid")
    private List<Boardview> boardviewList;
    @JoinColumn(name = "restaurantid", referencedColumnName = "restaurantid")
    @ManyToOne(optional = false)
    private Restaurant restaurantid;

    public Board() {
    }

    public Board(Integer boardid) {
        this.boardid = boardid;
    }

    public Board(Integer boardid, int capacity) {
        this.boardid = boardid;
        this.capacity = capacity;
    }

    public String getTableinformation() {
        return tableinformation;
    }

    public void setTableinformation(String tableinformation) {
        this.tableinformation = tableinformation;
    }

    public Integer getBoardid() {
        return boardid;
    }

    public void setBoardid(Integer boardid) {
        this.boardid = boardid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public List<Boardreservation> getBoardreservationList() {
        return boardreservationList;
    }

    public void setBoardreservationList(List<Boardreservation> boardreservationList) {
        this.boardreservationList = boardreservationList;
    }

    @XmlTransient
    public List<Boardview> getBoardviewList() {
        return boardviewList;
    }

    public void setBoardviewList(List<Boardview> boardviewList) {
        this.boardviewList = boardviewList;
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
        hash += (boardid != null ? boardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Board)) {
            return false;
        }
        Board other = (Board) object;
        if ((this.boardid == null && other.boardid != null) || (this.boardid != null && !this.boardid.equals(other.boardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Board[ boardid=" + boardid + " ]";
    }
    
}
