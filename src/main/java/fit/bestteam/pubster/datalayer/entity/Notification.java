/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author illia
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
    , @NamedQuery(name = "Notification.findByDate", query = "SELECT n FROM Notification n WHERE n.date = :date")
    , @NamedQuery(name = "Notification.findByState", query = "SELECT n FROM Notification n WHERE n.state = :state")
    , @NamedQuery(name = "Notification.findByNotificationid", query = "SELECT n FROM Notification n WHERE n.notificationid = :notificationid")
    , @NamedQuery(name = "Notification.findByType", query = "SELECT n FROM Notification n WHERE n.type = :type")
    , @NamedQuery(name = "Notification.findByData", query = "SELECT n FROM Notification n WHERE n.data = :data")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notificationid")
    private Integer notificationid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Notification() {
    }

    public Notification(Integer notificationid) {
        this.notificationid = notificationid;
    }

    public Notification(Integer notificationid, Date date, int state, String type, String data) {
        this.notificationid = notificationid;
        this.date = date;
        this.state = state;
        this.type = type;
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(Integer notificationid) {
        this.notificationid = notificationid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
        hash += (notificationid != null ? notificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationid == null && other.notificationid != null) || (this.notificationid != null && !this.notificationid.equals(other.notificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Notification[ notificationid=" + notificationid + " ]";
    }
    
}
