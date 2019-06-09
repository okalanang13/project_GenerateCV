/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author ASUS
 */
@Entity
@Table(name = "subdistrict")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdistrict.findAll", query = "SELECT s FROM Subdistrict s")
    , @NamedQuery(name = "Subdistrict.findById", query = "SELECT s FROM Subdistrict s WHERE s.id = :id")
    , @NamedQuery(name = "Subdistrict.findByName", query = "SELECT s FROM Subdistrict s WHERE s.name = :name")
    , @NamedQuery(name = "Subdistrict.findByIsDelete", query = "SELECT s FROM Subdistrict s WHERE s.isDelete = :isDelete")})
public class Subdistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;
    @Column(name = "isDelete")
    private Character isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubdistrict", fetch = FetchType.LAZY)
    private List<Village> villageList;
    @JoinColumn(name = "id_district", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private District idDistrict;

    public Subdistrict() {
    }

    public Subdistrict(String id) {
        this.id = id;
    }

    public Subdistrict(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Character isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<Village> getVillageList() {
        return villageList;
    }

    public void setVillageList(List<Village> villageList) {
        this.villageList = villageList;
    }

    public District getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(District idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subdistrict)) {
            return false;
        }
        Subdistrict other = (Subdistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.mii.bootcamp.mii.entities.Subdistrict[ id=" + id + " ]";
    }
    
}
