/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.usecase.impl;

import com.jobits.pos.cliente.core.domain.ClienteDomain;
import com.jobits.pos.cliente.core.module.ClienteCoreModule;
import com.jobits.pos.cliente.core.repo.ClienteRepo;
import com.jobits.pos.cliente.core.usecase.ClienteUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;

public class ClienteUseCaseImpl extends DefaultCRUDUseCase<ClienteDomain> implements ClienteUseCase {

    public ClienteUseCaseImpl() {
        setRepo(ClienteCoreModule.getInstance().getImplementation(ClienteRepo.class));
    }

    @Override
    public ClienteDomain findClientByPhone(String phone) {
        throw new UnsupportedOperationException();
    }

}
