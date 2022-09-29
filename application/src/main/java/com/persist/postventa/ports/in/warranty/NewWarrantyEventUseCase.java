package com.persist.postventa.ports.in.warranty;

import com.persist.postventa.generic.WarrantyDomain;

@FunctionalInterface
public interface NewWarrantyEventUseCase {
    WarrantyDomain newWarrantyEvent(WarrantyDomain warrantyDomain);
}
