/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl.entity;

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
@Table(name = "blog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b")
    , @NamedQuery(name = "Blog.findByDate", query = "SELECT b FROM Blog b WHERE b.date = :date")
    , @NamedQuery(name = "Blog.findByHtmltext", query = "SELECT b FROM Blog b WHERE b.htmltext = :htmltext")
    , @NamedQuery(name = "Blog.findByBlogid", query = "SELECT b FROM Blog b WHERE b.blogid = :blogid")})
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "htmltext")
    private String htmltext;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "blogid")
    private Integer blogid;
    @JoinColumn(name = "restaurantid", referencedColumnName = "restaurantid")
    @ManyToOne(optional = false)
    private Restaurant restaurantid;

    public Blog() {
    }

    public Blog(Integer blogid) {
        this.blogid = blogid;
    }

    public Blog(Integer blogid, Date date, String htmltext) {
        this.blogid = blogid;
        this.date = date;
        this.htmltext = htmltext;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHtmltext() {
        return htmltext;
    }

    public void setHtmltext(String htmltext) {
        this.htmltext = htmltext;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
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
        hash += (blogid != null ? blogid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) object;
        if ((this.blogid == null && other.blogid != null) || (this.blogid != null && !this.blogid.equals(other.blogid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Blog[ blogid=" + blogid + " ]";
    }
    
}
