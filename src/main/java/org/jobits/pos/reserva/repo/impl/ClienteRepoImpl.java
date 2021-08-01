/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.reserva.repo.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jobits.pos.cliente.core.domain.ClienteDomain;
import com.jobits.pos.cliente.core.repo.ClienteRepo;
import com.root101.clean.core.app.repo.Converter;
import com.root101.clean.core.domain.services.ResourceHandler;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jobits.db.utils.JpaCRUDRepository;
import org.jobits.pos.cliente.repo.entity.Cliente;
import org.jobits.pos.cliente.repo.entity.ClienteMeta;
import org.jobits.pos.cliente.repo.entity.DireccionEnvio;

public class ClienteRepoImpl extends AbstractRepo<ClienteDomain, Cliente>
        implements ClienteRepo {

    public ClienteRepoImpl() {
        super(ClienteDomain.class, Cliente.class);
        converter = new Converter<ClienteDomain, Cliente>() {
            @Override
            public ClienteDomain from(Cliente entity) {
                try {
                    return (ClienteDomain) mapper.readValue(mapper.writeValueAsString(entity), domainClass);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(JpaCRUDRepository.class.getName()).log(Level.SEVERE, null, ex);
                    throw new IllegalStateException(ResourceHandler.getString("msg.com.jobits.exception.parsing_exception"));
                }
            }

            @Override
            public Cliente to(ClienteDomain domain) {
                try {
                    var ret = (Cliente) mapper.readValue(mapper.writeValueAsString(domain), entityClass);
                    for (ClienteMeta c : ret.getClienteMetaList()) {
                        c.setClienteid(ret);
                    }
                    for (DireccionEnvio d : ret.getDireccionEnvioList()) {
                        d.setClienteid(ret);
                    }
                    return ret;
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(JpaCRUDRepository.class.getName()).log(Level.SEVERE, null, ex);
                    throw new IllegalStateException(ResourceHandler.getString("msg.com.jobits.exception.parsing_exception"));
                }
            }

            @Override
            public List<ClienteDomain> from(List<Cliente> list) {
                try {
                    List<ClienteDomain> ret = Converter.super.from(list); //To change body of generated methods, choose Tools | Templates.
                    if (!ret.isEmpty()) {
                        ClienteDomain d = ret.get(0);
                    }
                    return ret;
                } catch (Exception ex) {
                    Logger.getLogger(JpaCRUDRepository.class.getName()).log(Level.SEVERE, null, ex);
                    throw new IllegalStateException(ResourceHandler.getString("msg.com.jobits.exception.parsing_exception"));
                }
            }

        };
    }

}
