package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.ports.in.apartment.FindApartmentByIdUseCase;
import com.persist.postventa.ports.in.apartment.ListApartmentUseCase;
import com.persist.postventa.ports.in.apartment.SaveApartmentUseCase;
import com.persist.postventa.ports.in.apartment.ApartmentCommand;
import com.persist.postventa.ports.out.apartment.FindApartmentByIdPort;
import com.persist.postventa.ports.out.apartment.ListApartmentPort;
import com.persist.postventa.ports.out.apartment.SaveApartmentPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "apartmentService")
public class ApartmentService implements ListApartmentUseCase, SaveApartmentUseCase, FindApartmentByIdUseCase {
    private final ListApartmentPort listApartmentPort;
    private final FindApartmentByIdPort findApartmentByIdPort;
    //private final SaveApartmentPort saveApartmentPort;

    @Override
    public List<ApartmentDomain> findAll() {
        return this.listApartmentPort.findAll();
    }

    @Override
    public ApartmentDomain save(ApartmentCommand apartmentCommand) {
        ApartmentDomain apartment = ApartmentDomain.builder()
                .name(apartmentCommand.getName())
                .deliveryDate(apartmentCommand.getDeliveryDate())
                .status(apartmentCommand.getStatus())
                .build();
        return null; //this.saveApartmentPort.save(apartment);
    }

    @Override
    public ApartmentDomain findById(Long id) {
        return this.findApartmentByIdPort.findById(id);
    }
}
