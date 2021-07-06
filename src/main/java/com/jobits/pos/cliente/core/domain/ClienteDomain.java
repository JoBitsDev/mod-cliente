/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.root101.clean.core.domain.DomainObjectValitaded;
import java.util.ArrayList;
import java.util.List;
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
public class ClienteDomain extends DomainObjectValitaded {

    private int id;
    @NotNull
    @Size(min = 1, max = 255)
    private String nombre;
    @Size(max = 50)
    private String apellidos;
    @Size(max = 50)
    private String correo;
    @Size(max = 255)
    private String fotoUrl;
    @NotNull
    @Size(min = 1, max = 20)
    private String telefono;
    private List<DireccionEnvioDomain> direccionEnvioList = new ArrayList<>();
    private List<ClienteMetaDomain> clienteMetaList = new ArrayList<>();

    public ClienteDomain() {
    }

    public ClienteDomain(Integer id) {
        this.id = id;
    }

    public ClienteDomain(Integer id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<DireccionEnvioDomain> getDireccionEnvioList() {
        return direccionEnvioList;
    }

    public void setDireccionEnvioList(List<DireccionEnvioDomain> direccionEnvioList) {
        this.direccionEnvioList = direccionEnvioList;
    }

    public List<ClienteMetaDomain> getClienteMetaList() {
        return new ArrayList<>(clienteMetaList);
    }

    public void setClienteMetaList(List<ClienteMetaDomain> clienteMetaList) {
        this.clienteMetaList = clienteMetaList;
    }

    //
    // Metodos con el cliente
    //
    public ClienteMetaDomain addMeta(String key, String value) {
        ClienteMetaDomain newMeta = new ClienteMetaDomain(key, value);
        clienteMetaList.add(newMeta);
        return newMeta;
    }

    public ClienteMetaDomain getMeta(String key) {
        for (ClienteMetaDomain c : clienteMetaList) {
            if (c.getName().equals(key)) {
                return c;
            }
        }
        return null;
    }

    public ClienteMetaDomain removeMeta(String key) {
        for (ClienteMetaDomain c : clienteMetaList) {
            if (c.getName().equals(key)) {
                clienteMetaList.remove(c);
                return c;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteDomain other = (ClienteDomain) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobits.pos.cliente.core.domain.Cliente[ id=" + id + " ]";
    }

}
