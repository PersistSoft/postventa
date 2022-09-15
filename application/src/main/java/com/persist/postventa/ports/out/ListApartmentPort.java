package com.persist.postventa.ports.out;

import com.persist.postventa.generic.ApartmentDomain;

import java.util.List;

@FunctionalInterface
public interface ListApartmentPort {
    List<ApartmentDomain> findAll();
}
