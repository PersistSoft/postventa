package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.ListWarrantyUseCase;
import com.persist.postventa.ports.out.ListWarrantyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class WarrantyService implements ListWarrantyUseCase {
    private final ListWarrantyPort listWarrantyPort;

    @Override
    public List<SocietyDomain> findAll() {
        return this.listWarrantyPort.findAll();
    }
}
