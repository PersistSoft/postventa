package com.persist.postventa.ports.in.society;

import com.persist.postventa.generic.SocietyDomain;

@FunctionalInterface
public interface SaveSocietyUseCase {
    SocietyDomain save(SocietyCommand societyCommand);
}
