package com.persist.postventa.ports.out;

import com.persist.postventa.generic.SocietyDomain;

@FunctionalInterface
public interface SaveSocietyPort {
    SocietyDomain save(SocietyDomain societyDomain);
}
