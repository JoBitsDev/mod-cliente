/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.jobits.pos.cliente.core.repo.ClienteRepo;
import com.jobits.pos.cliente.core.usecase.ClienteUseCase;
import com.jobits.pos.cliente.core.usecase.impl.ClienteUseCaseImpl;
import com.jobits.pos.reserva.repo.impl.ClienteRepoImpl;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
class ClienteInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {

        bind(ClienteUseCase.class).to(ClienteUseCaseImpl.class).in(Scopes.SINGLETON);
        
        bind(ClienteRepo.class).to(ClienteRepoImpl.class).in(Scopes.SINGLETON);

    }

}
