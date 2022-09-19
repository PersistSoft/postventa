package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.enums.ApartmentStatusEnum;
import com.persist.postventa.exceptions.ServiceException;
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
    public WarrantyDomain save(WarrantyCommand warrantyCommand) {
        try {
            if(isNull(warrantyCommand.getApartmentId())){
                //TODO Handle custom exception
                throw new ServiceException("Project id is necessary to create warranty");
            }

            if(isNull(warrantyCommand.getClientId())){
                //TODO Handle custom exception
                throw new ServiceException("Client id is necessary to create warranty");
            }

            ApartmentDomain apartment = this.findApartmentByIdPort.findById(warrantyCommand.getApartmentId());
            ClientDomain client = this.findClientByIdPort.findById(warrantyCommand.getClientId());

            if(isNull(apartment)){
                //TODO Handle custom exception
                throw new ServiceException("Apartment not found");
            }

            if(apartment.getStatus().equals(ApartmentStatusEnum.PENDING.getStatus())){
                //TODO Handle custom exception
                throw new ServiceException("The apartment is not delivered yet");
            }

            WarrantyDomain warranty = WarrantyDomain.builder()
                    .apartment(apartment)
                    .client(client)
                    .creationDate(new Date()).build();
            return this.saveWarrantyPort.save(warranty);

        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return null;
    }
}
