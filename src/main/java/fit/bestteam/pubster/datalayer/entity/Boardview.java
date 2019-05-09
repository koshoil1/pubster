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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author illia
 */
@Entity
@Table(name = "boardview", catalog = "pubster", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boardview.findAll", query = "SELECT b FROM Boardview b")
    , @NamedQuery(name = "Boardview.findByBoardviewid", query = "SELECT b FROM Boardview b WHERE b.boardviewid = :boardviewid")
    , @NamedQuery(name = "Boardview.findByType", query = "SELECT b FROM Boardview b WHERE b.type = :type")})
public class Boardview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "boardviewid")
    private Integer boardviewid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boardviewid")
    private List<Board> boardList;

    public Boardview() {
    }

    public Boardview(Integer boardviewid) {
        this.boardviewid = boardviewid;
    }

    public Boardview(Integer boardviewid, int type) {
        this.boardviewid = boardviewid;
        this.type = type;
    }

    public Integer getBoardviewid() {
        return boardviewid;
    }

    public void setBoardviewid(Integer boardviewid) {
        this.boardviewid = boardviewid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @XmlTransient
    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boardviewid != null ? boardviewid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boardview)) {
            return false;
        }
        Boardview other = (Boardview) object;
        if ((this.boardviewid == null && other.boardviewid != null) || (this.boardviewid != null && !this.boardviewid.equals(other.boardviewid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Boardview[ boardviewid=" + boardviewid + " ]";
    }
    
}
