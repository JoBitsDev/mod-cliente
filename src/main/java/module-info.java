/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module org.jobits.pos.cliente {
    requires com.google.guice;
    requires com.fasterxml.jackson.databind;
    requires java.logging;
    requires java.desktop;
    requires com.root101clean.core;
    requires org.jobits.db;

    exports com.jobits.pos.cliente.core.domain;
    exports com.jobits.pos.cliente.core.usecase;
    exports com.jobits.pos.cliente.core.repo;
    exports com.jobits.pos.cliente.core.module;
    exports com.jobits.pos.cliente.repo.module;
}
