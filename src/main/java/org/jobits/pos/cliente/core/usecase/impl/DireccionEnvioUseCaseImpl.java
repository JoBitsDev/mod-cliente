/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.cliente.core.usecase.impl;

import com.jobits.pos.cliente.core.domain.DireccionEnvioDomain;
import com.jobits.pos.cliente.core.module.ClienteCoreModule;
import com.jobits.pos.cliente.core.repo.DireccionEnvioRepo;
import com.jobits.pos.cliente.core.usecase.DireccionEnvioUseCase;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;

/**
 *
 * @author Home
 */
public class DireccionEnvioUseCaseImpl extends DefaultCRUDUseCase<DireccionEnvioDomain> implements DireccionEnvioUseCase {

    public DireccionEnvioUseCaseImpl() {
        setRepo(ClienteCoreModule.getInstance().getImplementation(DireccionEnvioRepo.class));
    }
}
