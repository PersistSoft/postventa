package com.persist.postventa.ports.out.society;

import com.persist.postventa.generic.SocietyDomain;

@FunctionalInterface
public interface SaveSocietyPort {
    SocietyDomain save(SocietyDomain societyDomain);
}
