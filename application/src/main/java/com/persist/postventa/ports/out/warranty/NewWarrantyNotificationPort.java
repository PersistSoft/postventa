package com.persist.postventa.ports.out.warranty;

import com.persist.postventa.generic.WarrantyDomain;

public interface NewWarrantyNotificationPort {
    WarrantyDomain send(WarrantyDomain warrantyDomain);
}
