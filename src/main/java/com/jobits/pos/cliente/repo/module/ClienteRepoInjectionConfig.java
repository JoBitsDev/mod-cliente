/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.jobits.pos.reserva.repo.impl.ClienteRepoImpl;
import com.jobits.pos.cliente.core.repo.ClienteRepo;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
class ClienteRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(ClienteRepo.class).to(ClienteRepoImpl.class).in(Singleton.class);
    }

}
