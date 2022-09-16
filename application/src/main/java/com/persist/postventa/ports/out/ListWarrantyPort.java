package com.persist.postventa.ports.out;

import com.persist.postventa.generic.WarrantyDomain;

import java.util.List;

@FunctionalInterface
public interface ListWarrantyPort {
    List<WarrantyDomain> findAll();
}
