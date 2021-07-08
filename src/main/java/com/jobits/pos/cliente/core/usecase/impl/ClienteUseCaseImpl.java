/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.usecase.impl;

import com.jobits.pos.cliente.core.domain.ClienteDomain;
import com.jobits.pos.cliente.core.domain.ClienteMetaDomain;
import com.jobits.pos.cliente.core.domain.DireccionEnvioDomain;
import com.jobits.pos.cliente.core.module.ClienteCoreModule;
import com.jobits.pos.cliente.core.repo.ClienteRepo;
import com.jobits.pos.cliente.core.usecase.ClienteUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import java.util.ArrayList;
import java.util.List;

public class ClienteUseCaseImpl extends DefaultCRUDUseCase<ClienteDomain> implements ClienteUseCase {

    public ClienteUseCaseImpl() {
        setRepo(ClienteCoreModule.getInstance().getImplementation(ClienteRepo.class));
    }

    @Override
    public ClienteDomain findClientByPhone(String phone) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ClienteDomain create(ClienteDomain newObject) throws RuntimeException {
        List<DireccionEnvioDomain> list_dir_envio = newObject.getDireccionEnvioList();
        List<ClienteMetaDomain> list_meta = newObject.getClienteMetaList();

        newObject.setClienteMetaList(new ArrayList<>());
        newObject.setDireccionEnvioList(new ArrayList<>());

        getRepo().startTransaction();
        newObject = getRepo().create(newObject);
        getRepo().commitTransaction();

        for (DireccionEnvioDomain d : list_dir_envio) {
            d.setId(newObject.getId());
        }

        for (ClienteMetaDomain m : list_meta) {
            m.setId(newObject.getId());
        }

        newObject.setDireccionEnvioList(list_dir_envio);
        newObject.setClienteMetaList(list_meta);

        getRepo().startTransaction();
        newObject = getRepo().edit(newObject);
        getRepo().commitTransaction();

        return newObject;
    }

}
