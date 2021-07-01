/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.reserva.repo.impl;

import com.jobits.pos.cliente.core.repo.ClienteRepo;

public class ClienteRepoImpl extends AbstractRepo<
        com.jobits.pos.cliente.core.domain.ClienteDomain, com.jobits.pos.cliente.repo.entity.Cliente>
        implements ClienteRepo {

    public ClienteRepoImpl() {
        super(com.jobits.pos.cliente.core.domain.ClienteDomain.class,
                com.jobits.pos.cliente.repo.entity.Cliente.class);
    }

}
