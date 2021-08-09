/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.reserva.repo.impl;

import com.jobits.pos.cliente.core.domain.DireccionEnvioDomain;
import com.jobits.pos.cliente.core.repo.DireccionEnvioRepo;
import org.jobits.pos.cliente.repo.entity.DireccionEnvio;

/**
 *
 * @author Home
 */
public class DireccionEnvioRepoImpl extends AbstractRepo<DireccionEnvioDomain, DireccionEnvio>
        implements DireccionEnvioRepo {

    public DireccionEnvioRepoImpl() {
        super(DireccionEnvioDomain.class, DireccionEnvio.class);
    }

}
