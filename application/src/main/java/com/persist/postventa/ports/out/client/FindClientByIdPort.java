package com.persist.postventa.ports.out.client;

import com.persist.postventa.generic.ClientDomain;

@FunctionalInterface
public interface FindClientByIdPort {
    ClientDomain findById(Long id);
}
