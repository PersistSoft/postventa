package com.persist.postventa.ports.in.client;

import com.persist.postventa.generic.ClientDomain;

@FunctionalInterface
public interface FindClientByIdUseCase {
    ClientDomain findById(Long id);
}
