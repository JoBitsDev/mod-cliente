/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.repo.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.AlreadyInitModule;
import com.root101.clean.core.exceptions.NotInitModule;
import org.jobits.db.pool.ConnectionPoolHandler;
import org.jobits.db.versioncontrol.DataVersionControlHandler;
import org.jobits.db.versioncontrol.DataVersionControlService;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class ClienteRepoModule extends DefaultAbstractModule {

    public static final String MODULE_NAME = "Reserva Repo Module";

    private final Injector inj = Guice.createInjector(new ClienteRepoInjectionConfig());

    private static ClienteRepoModule INSTANCE;

    private ClienteRepoModule() {
        registerResources();
        registerConnectionPool();

    }

    public static ClienteRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NotInitModule(ResourceHandler.getString("com.jobits.pos.clienterepo.name"));
        }
        return INSTANCE;
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @return
     * @Deprecated
     */
    public static ClienteRepoModule init(AbstractModule... modules) {
        if (INSTANCE != null) {
            throw new AlreadyInitModule(ResourceHandler.getString("com.jobits.pos.clienterepo.name"));
        }
        INSTANCE = new ClienteRepoModule();
        for (AbstractModule m : modules) {
            INSTANCE.registerModule(m);
        }
        return getInstance();
    }

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    private void registerConnectionPool() {
        ConnectionPoolHandler.registerConnectionPoolService(getModuleName(),"JoBits POS Cliente Repo PU");//TODO: resourcehandler
        String schema = ResourceHandler.getString("com.jobits.pos.cliente.repo.db.shema");
        String dir = "org/jobits/pos/cliente/db/migration";
        DataVersionControlHandler.registerDataVersionControlService(DataVersionControlService.from(MODULE_NAME, dir, schema));

    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    private void registerResources() {
        ResourceHandler.registerInternal("cliente_module");
    }

}
