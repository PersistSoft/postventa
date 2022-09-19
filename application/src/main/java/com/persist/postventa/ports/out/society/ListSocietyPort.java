package com.persist.postventa.ports.out.society;

import com.persist.postventa.generic.SocietyDomain;

import java.util.List;

@FunctionalInterface
public interface ListSocietyPort {
    List<SocietyDomain> findAll();
}
