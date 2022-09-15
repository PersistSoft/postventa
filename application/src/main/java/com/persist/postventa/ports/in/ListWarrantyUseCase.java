package com.persist.postventa.ports.in;

import com.persist.postventa.generic.SocietyDomain;

import java.util.List;

@FunctionalInterface
public interface ListWarrantyUseCase {
    List<SocietyDomain> findAll();
}
