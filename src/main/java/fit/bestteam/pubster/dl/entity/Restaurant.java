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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r")
    , @NamedQuery(name = "Restaurant.findByEmail", query = "SELECT r FROM Restaurant r WHERE r.email = :email")
    , @NamedQuery(name = "Restaurant.findByName", query = "SELECT r FROM Restaurant r WHERE r.name = :name")
    , @NamedQuery(name = "Restaurant.findByDescription", query = "SELECT r FROM Restaurant r WHERE r.description = :description")
    , @NamedQuery(name = "Restaurant.findByTelephone", query = "SELECT r FROM Restaurant r WHERE r.telephone = :telephone")
    , @NamedQuery(name = "Restaurant.findByWebaddress", query = "SELECT r FROM Restaurant r WHERE r.webaddress = :webaddress")
    , @NamedQuery(name = "Restaurant.findByRestaurantid", query = "SELECT r FROM Restaurant r WHERE r.restaurantid = :restaurantid")})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 100)
    @Column(name = "webaddress")
    private String webaddress;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "restaurantid")
    private Integer restaurantid;
    @ManyToMany(mappedBy = "restaurantList")
    private List<Category> categoryList;
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Address addressid;
    @JoinColumn(name = "managerid", referencedColumnName = "managerid")
    @ManyToOne(optional = false)
    private Manager managerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantid")
    private List<Photo> photoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantid")
    private List<Staff> staffList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantid")
    private List<Blog> blogList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantid")
    private List<Board> boardList;

    public Restaurant() {
    }

    public Restaurant(Integer restaurantid) {
        this.restaurantid = restaurantid;
    }

    public Restaurant(Integer restaurantid, String email, String name, byte[] logo, String telephone) {
        this.restaurantid = restaurantid;
        this.email = email;
        this.name = name;
        this.logo = logo;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }

    public Integer getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Integer restaurantid) {
        this.restaurantid = restaurantid;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    public Manager getManagerid() {
        return managerid;
    }

    public void setManagerid(Manager managerid) {
        this.managerid = managerid;
    }

    @XmlTransient
    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @XmlTransient
    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @XmlTransient
    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
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
        hash += (restaurantid != null ? restaurantid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restaurantid == null && other.restaurantid != null) || (this.restaurantid != null && !this.restaurantid.equals(other.restaurantid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit.bestteam.pubster.dl.entity.Restaurant[ restaurantid=" + restaurantid + " ]";
    }
    
}
