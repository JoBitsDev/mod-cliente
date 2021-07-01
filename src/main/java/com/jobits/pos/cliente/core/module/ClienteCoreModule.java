/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobits.pos.cliente.core.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.AlreadyInitModule;
import com.root101.clean.core.exceptions.NotInitModule;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class ClienteCoreModule extends DefaultAbstractModule {

    public static final String MODULE_NAME = "Clientes Core Module";

    private final Injector inj = Guice.createInjector(new ClienteInjectionConfig());

    private static ClienteCoreModule INSTANCE;

    public static ClienteCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NotInitModule(ResourceHandler.getString("com.jobits.pos.cliente.name"));
        }
        return INSTANCE;
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @return
     * @Deprecated
     */
    public static ClienteCoreModule init(AbstractModule... modules) {
        if (INSTANCE != null) {
            throw new AlreadyInitModule(ResourceHandler.getString("com.jobits.pos.cliente.name"));
        }
        INSTANCE = new ClienteCoreModule();

        for (AbstractModule m : modules) {
            INSTANCE.registerModule(m);
        }
        return getInstance();
    }

    private ClienteCoreModule() {
    }

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

}
