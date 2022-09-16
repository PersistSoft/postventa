package com.persist.postventa.ports.in;

import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.commands.SocietyCommand;

@FunctionalInterface
public interface SaveSocietyUseCase {
    SocietyDomain save(SocietyCommand societyCommand);
}
