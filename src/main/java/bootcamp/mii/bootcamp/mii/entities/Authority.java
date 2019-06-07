/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "authority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authority.findAll", query = "SELECT a FROM Authority a")
    , @NamedQuery(name = "Authority.findById", query = "SELECT a FROM Authority a WHERE a.id = :id")
    , @NamedQuery(name = "Authority.findByName", query = "SELECT a FROM Authority a WHERE a.name = :name")
    , @NamedQuery(name = "Authority.findByIsDelete", query = "SELECT a FROM Authority a WHERE a.isDelete = :isDelete")})
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "is_delete")
    private Character isDelete;

    public Authority() {
    }

    public Authority(Integer id) {
        this.id = id;
    }

    public Authority(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authority)) {
            return false;
        }
        Authority other = (Authority) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bootcamp.mii.bootcamp.mii.entities.Authority[ id=" + id + " ]";
    }
    
}
