package com.persist.postventa.ports.out.warranty;

import com.persist.postventa.generic.WarrantyDomain;

@FunctionalInterface
public interface NewWarrantyEventPort {
    WarrantyDomain newWarrantyEvent(WarrantyDomain warrantyDomain);
}
