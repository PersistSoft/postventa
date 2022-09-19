package com.persist.postventa.ports.in.apartment;

import com.persist.postventa.generic.ApartmentDomain;

import java.util.List;

@FunctionalInterface
public interface ListApartmentUseCase {
    List<ApartmentDomain> findAll();
}
