package com.persist.postventa.ports.out;

import com.persist.postventa.generic.SocietyDomain;

import java.util.List;

@FunctionalInterface
public interface ListSocietyPort {
    List<SocietyDomain> findAll();
}
