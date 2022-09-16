package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.ports.in.ListApartmentUseCase;
import com.persist.postventa.ports.out.ListApartmentPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "apartmentService")
public class ApartmentService implements ListApartmentUseCase {
    private final ListApartmentPort listApartmentPort;

    @Override
    public List<ApartmentDomain> findAll() {
        return this.listApartmentPort.findAll();
    }
}
