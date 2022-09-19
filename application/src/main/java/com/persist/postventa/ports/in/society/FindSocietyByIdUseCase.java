package com.persist.postventa.ports.in.society;

import com.persist.postventa.generic.SocietyDomain;

@FunctionalInterface
public interface FindSocietyByIdUseCase {
    SocietyDomain findById(Long id);
}
