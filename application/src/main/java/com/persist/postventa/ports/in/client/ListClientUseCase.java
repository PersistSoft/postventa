package com.persist.postventa.ports.in.client;

import com.persist.postventa.generic.ClientDomain;

import java.util.List;

@FunctionalInterface
public interface ListClientUseCase {
    List<ClientDomain> findAll();
}
