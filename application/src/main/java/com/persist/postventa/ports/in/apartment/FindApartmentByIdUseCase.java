package com.persist.postventa.ports.in.apartment;

import com.persist.postventa.generic.ApartmentDomain;

@FunctionalInterface
public interface FindApartmentByIdUseCase {
    ApartmentDomain findById(Long id);
}
