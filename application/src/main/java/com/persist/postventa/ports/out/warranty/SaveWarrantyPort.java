package com.persist.postventa.ports.out.warranty;

import com.persist.postventa.generic.WarrantyDomain;

@FunctionalInterface
public interface SaveWarrantyPort {
    WarrantyDomain save(WarrantyDomain societyDomain);
}
