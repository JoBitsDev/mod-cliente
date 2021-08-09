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
import com.jobits.pos.cliente.core.repo.DireccionEnvioRepo;
import com.jobits.pos.cliente.core.usecase.ClienteUseCase;
import com.jobits.pos.cliente.core.usecase.DireccionEnvioUseCase;
import org.jobits.pos.cliente.core.usecase.impl.ClienteUseCaseImpl;
import org.jobits.pos.cliente.core.usecase.impl.DireccionEnvioUseCaseImpl;
import org.jobits.pos.reserva.repo.impl.DireccionEnvioRepoImpl;

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
        bind(DireccionEnvioRepo.class).to(DireccionEnvioRepoImpl.class).in(Singleton.class);

        bind(DireccionEnvioUseCase.class).to(DireccionEnvioUseCaseImpl.class).in(Singleton.class);
        bind(ClienteUseCase.class).to(ClienteUseCaseImpl.class).in(Singleton.class);
    }

}
