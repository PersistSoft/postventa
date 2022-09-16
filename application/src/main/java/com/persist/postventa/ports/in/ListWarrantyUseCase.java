package com.persist.postventa.ports.in;

import com.persist.postventa.generic.WarrantyDomain;

import java.util.List;

@FunctionalInterface
public interface ListWarrantyUseCase {
    List<WarrantyDomain> findAll();
}
