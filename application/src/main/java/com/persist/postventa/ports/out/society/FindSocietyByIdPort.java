package com.persist.postventa.ports.out.society;

import com.persist.postventa.generic.SocietyDomain;

@FunctionalInterface
public interface FindSocietyByIdPort {
    SocietyDomain findById(Long id);
}
