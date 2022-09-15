package com.persist.postventa.ports.out;

import com.persist.postventa.generic.ClientDomain;

import java.util.List;

@FunctionalInterface
public interface ListClientPort {
    List<ClientDomain> findAll();
}
