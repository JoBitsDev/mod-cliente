/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.domain;

import com.root101.clean.core.domain.DomainObjectValitaded;
import javax.validation.constraints.NotNull;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class ClienteMetaDomain extends DomainObjectValitaded {

    private int id;
    @NotNull
    private String name;
    @NotNull
    private String value;

    public ClienteMetaDomain() {
    }

    public ClienteMetaDomain(Integer id) {
        this.id = id;
    }

    public ClienteMetaDomain(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public ClienteMetaDomain(int id, String name, String value) {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final ClienteMetaDomain other = (ClienteMetaDomain) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteMeta{" + "id=" + id + ", name=" + name + ", value=" + value + '}';
    }

}
