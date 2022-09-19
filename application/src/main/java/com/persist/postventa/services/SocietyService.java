package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.society.FindSocietyByIdUseCase;
import com.persist.postventa.ports.in.society.ListSocietyUseCase;
import com.persist.postventa.ports.in.society.SaveSocietyUseCase;
import com.persist.postventa.ports.in.society.SocietyCommand;
import com.persist.postventa.ports.out.society.FindSocietyByIdPort;
import com.persist.postventa.ports.out.society.ListSocietyPort;
import com.persist.postventa.ports.out.society.SaveSocietyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "societyService")
public class SocietyService implements ListSocietyUseCase, SaveSocietyUseCase, FindSocietyByIdUseCase {
    private final ListSocietyPort listSocietyPort;
    private final SaveSocietyPort saveSocietyPort;
    private final FindSocietyByIdPort findSocietyByIdPort;

    @Override
    public List<SocietyDomain> findAll() {
        log.info("{} findAll", SocietyService.class.getSimpleName());
        return this.listSocietyPort.findAll();
    }

    @Override
    public SocietyDomain save(SocietyCommand societyCommand) {
        SocietyDomain societyDomain = SocietyDomain.builder()
                .name(societyCommand.getName())
                .nit(societyCommand.getNit()).build();
        return this.saveSocietyPort.save(societyDomain);
    }

    @Override
    public SocietyDomain findById(Long id) {
        return this.findSocietyByIdPort.findById(id);
    }
}
