/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jobits.pos.cliente.repo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.Size;

/**
 * 
 * JoBits
 * @author Jorge
 * 
 */
@Entity
@Table(name = "cliente_meta", schema = "cliente")
@NamedQueries({
    @NamedQuery(name = "ClienteMeta.findAll", query = "SELECT c FROM ClienteMeta c"),
    @NamedQuery(name = "ClienteMeta.findById", query = "SELECT c FROM ClienteMeta c WHERE c.id = :id"),
    @NamedQuery(name = "ClienteMeta.findByName", query = "SELECT c FROM ClienteMeta c WHERE c.name = :name"),
    @NamedQuery(name = "ClienteMeta.findByValue", query = "SELECT c FROM ClienteMeta c WHERE c.value = :value")})
public class ClienteMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "clienteid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Cliente clienteid;

    public ClienteMeta() {
    }

    public ClienteMeta(Integer id) {
        this.id = id;
    }

    public ClienteMeta(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
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
        if (!(object instanceof ClienteMeta)) {
            return false;
        }
        ClienteMeta other = (ClienteMeta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jobits.pos.cliente.repo.entity.ClienteMeta[ id=" + id + " ]";
    }

}
