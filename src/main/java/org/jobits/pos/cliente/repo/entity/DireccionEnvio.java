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
@Table(name = "direccion_envio", schema = "cliente")
@NamedQueries({
    @NamedQuery(name = "DireccionEnvio.findAll", query = "SELECT d FROM DireccionEnvio d"),
    @NamedQuery(name = "DireccionEnvio.findById", query = "SELECT d FROM DireccionEnvio d WHERE d.id = :id"),
    @NamedQuery(name = "DireccionEnvio.findByAlias", query = "SELECT d FROM DireccionEnvio d WHERE d.alias = :alias"),
    @NamedQuery(name = "DireccionEnvio.findByNombre", query = "SELECT d FROM DireccionEnvio d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DireccionEnvio.findByApellidos", query = "SELECT d FROM DireccionEnvio d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "DireccionEnvio.findByTelefono", query = "SELECT d FROM DireccionEnvio d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "DireccionEnvio.findByEmpresa", query = "SELECT d FROM DireccionEnvio d WHERE d.empresa = :empresa"),
    @NamedQuery(name = "DireccionEnvio.findByDireccion", query = "SELECT d FROM DireccionEnvio d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DireccionEnvio.findByDireccionAdicional", query = "SELECT d FROM DireccionEnvio d WHERE d.direccionAdicional = :direccionAdicional"),
    @NamedQuery(name = "DireccionEnvio.findByCiudad", query = "SELECT d FROM DireccionEnvio d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "DireccionEnvio.findByProvincia", query = "SELECT d FROM DireccionEnvio d WHERE d.provincia = :provincia")})
public class DireccionEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 255)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "direccion_adicional")
    private String direccionAdicional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "provincia")
    private String provincia;
    @JoinColumn(name = "clienteid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Cliente clienteid;

    public DireccionEnvio() {
    }

    public DireccionEnvio(Integer id) {
        this.id = id;
    }

    public DireccionEnvio(Integer id, String alias, String nombre, String telefono, String direccion, String ciudad, String provincia) {
        this.id = id;
        this.alias = alias;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionAdicional() {
        return direccionAdicional;
    }

    public void setDireccionAdicional(String direccionAdicional) {
        this.direccionAdicional = direccionAdicional;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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
        if (!(object instanceof DireccionEnvio)) {
            return false;
        }
        DireccionEnvio other = (DireccionEnvio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jobits.pos.cliente.repo.entity.DireccionEnvio[ id=" + id + " ]";
    }

}
