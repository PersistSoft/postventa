package com.persist.postventa.ports.in.warranty;

import com.persist.postventa.exceptions.*;
import com.persist.postventa.generic.WarrantyDomain;

@FunctionalInterface
public interface SaveWarrantyUseCase {
    WarrantyDomain save(WarrantyCommand warrantyCommand) throws ApartmentIdNotFoundException, ClientIdNotFoundException,
        ApartmentNotFoundException, ClientNotFoundException, ApartmentStatusNotPermitException, ServiceException;
}
