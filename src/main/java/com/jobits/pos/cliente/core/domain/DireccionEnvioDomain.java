/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.root101.clean.core.domain.DomainObjectValitaded;
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
 *
 * @author Jorge
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DireccionEnvioDomain extends DomainObjectValitaded {

    private Integer id;
    @NotNull
    private String alias;
    @NotNull
    @Size(min = 1, max = 255)
    private String nombre;
    @Size(max = 255)
    private String apellidos;
    @NotNull
    @Size(min = 1, max = 255)
    private String telefono;
    @Size(max = 255)
    private String empresa;
    @NotNull
    @Size(min = 1, max = 255)
    private String direccion;
    @Size(max = 255)
    private String direccionAdicional;
    @NotNull
    @Size(min = 1, max = 255)
    private String ciudad;
    @NotNull
    @Size(min = 1, max = 255)
    private String provincia;

    public DireccionEnvioDomain() {
    }

    public DireccionEnvioDomain(Integer id, String alias, String nombre, String telefono, String direccion, String ciudad, String provincia) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionEnvioDomain)) {
            return false;
        }
        DireccionEnvioDomain other = (DireccionEnvioDomain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.reserva.repo.entity.DireccionEnvio[ id=" + id + " ]";
    }

}
