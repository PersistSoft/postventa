package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.ports.in.ListClientUseCase;
import com.persist.postventa.ports.out.ListApartmentPort;
import com.persist.postventa.ports.out.ListClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ClientService implements ListClientUseCase {
    private final ListClientPort listClientPort;
    @Override
    public List<ClientDomain> findAll() {
        return listClientPort.findAll();
    }
}
