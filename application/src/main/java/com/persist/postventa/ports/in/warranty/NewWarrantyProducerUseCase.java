package com.persist.postventa.ports.in.warranty;

import com.persist.postventa.generic.WarrantyDomain;

@FunctionalInterface
public interface NewWarrantyProducerUseCase {
    WarrantyDomain newWarrantyEvent(WarrantyDomain warrantyDomain);
}
