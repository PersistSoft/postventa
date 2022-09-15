package com.persist.postventa.ports.in;

import com.persist.postventa.generic.SocietyDomain;

import java.util.List;

@FunctionalInterface
public interface ListSocietyUseCase {
    List<SocietyDomain> findAll();
}
