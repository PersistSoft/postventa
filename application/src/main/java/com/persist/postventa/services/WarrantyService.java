package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.in.warranty.ListWarrantyUseCase;
import com.persist.postventa.ports.out.warranty.ListWarrantyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "warrantyService")
public class WarrantyService implements ListWarrantyUseCase {
    private final ListWarrantyPort listWarrantyPort;

    @Override
    public List<WarrantyDomain> findAll() {
        return this.listWarrantyPort.findAll();
    }
}
