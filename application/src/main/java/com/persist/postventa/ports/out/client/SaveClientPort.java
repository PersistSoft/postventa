package com.persist.postventa.ports.out.client;

import com.persist.postventa.generic.ClientDomain;

@FunctionalInterface
public interface SaveClientPort {
    ClientDomain save(ClientDomain societyDomain);
}
