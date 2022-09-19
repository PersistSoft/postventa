package com.persist.postventa.ports.in.apartment;

import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.ports.in.apartment.ApartmentCommand;

@FunctionalInterface
public interface SaveApartmentUseCase {
    ApartmentDomain save(ApartmentCommand apartmentCommand);
}
