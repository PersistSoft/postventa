package com.persist.postventa.ports.out.apartment;

import com.persist.postventa.generic.ApartmentDomain;

@FunctionalInterface
public interface SaveApartmentPort {
    ApartmentDomain save(ApartmentDomain societyDomain);
}
