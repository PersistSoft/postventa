package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.ListSocietyUseCase;
import com.persist.postventa.ports.out.ListSocietyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "societyService")
public class SocietyService implements ListSocietyUseCase {
    private final ListSocietyPort listSocietyPort;

    @Override
    public List<SocietyDomain> findAll() {
        log.info("{} findAll", SocietyService.class.getSimpleName());
        return this.listSocietyPort.findAll();
    }
}
