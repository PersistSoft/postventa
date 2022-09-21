package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.enums.ApartmentStatusEnum;
import com.persist.postventa.exceptions.*;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.in.warranty.ListWarrantyUseCase;
import com.persist.postventa.ports.in.warranty.SaveWarrantyUseCase;
import com.persist.postventa.ports.in.warranty.WarrantyCommand;
import com.persist.postventa.ports.out.apartment.FindApartmentByIdPort;
import com.persist.postventa.ports.out.client.FindClientByIdPort;
import com.persist.postventa.ports.out.warranty.ListWarrantyPort;
import com.persist.postventa.ports.out.warranty.SaveWarrantyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;

import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "warrantyService")
public class WarrantyService implements ListWarrantyUseCase, SaveWarrantyUseCase {
    private final ListWarrantyPort listWarrantyPort;
    private final SaveWarrantyPort saveWarrantyPort;
    private final FindClientByIdPort findClientByIdPort;
    private final FindApartmentByIdPort findApartmentByIdPort;

    @Override
    public List<WarrantyDomain> findAll() {
        return this.listWarrantyPort.findAll();
    }

    @Override
    public WarrantyDomain save(WarrantyCommand warrantyCommand) throws ApartmentIdNotFoundException,
            ClientIdNotFoundException, ApartmentNotFoundException, ClientNotFoundException,
            ApartmentStatusNotPermitException, ServiceException {

            if(isNull(warrantyCommand.getApartmentId())){
                throw new ApartmentIdNotFoundException("Project id is required to create warranty");
            }

            if(isNull(warrantyCommand.getClientId())){
                throw new ClientIdNotFoundException("Client id is required to create warranty");
            }

            ApartmentDomain apartment = this.findApartmentByIdPort.findById(warrantyCommand.getApartmentId());
            ClientDomain client = this.findClientByIdPort.findById(warrantyCommand.getClientId());

            if(isNull(apartment)){
                throw new ApartmentNotFoundException(String.format("The Apartment with id %s not found", warrantyCommand.getApartmentId()));
            }

            if(isNull(client)){
                throw new ClientNotFoundException(String.format("The client with id %s not found", warrantyCommand.getClientId()));
            }

            if(apartment.getStatus().equals(ApartmentStatusEnum.PENDING.getStatus())){
                throw new ApartmentStatusNotPermitException("The apartment is not delivered yet");
            }

        try {
            WarrantyDomain warranty = WarrantyDomain.builder()
                    .apartment(apartment)
                    .client(client)
                    .creationDate(new Date()).build();
            return this.saveWarrantyPort.save(warranty);

        } catch (Exception e) {
            throw new ServiceException("Internal server error saving warranty");
        }
    }
}
