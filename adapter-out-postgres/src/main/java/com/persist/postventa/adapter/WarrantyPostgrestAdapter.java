package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.WarrantyEntity;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.mapper.WarrantyPostgresMapper;
import com.persist.postventa.ports.out.warranty.ListWarrantyPort;
import com.persist.postventa.springdata.WarrantyPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "warrantyPostgrestAdapter")
public class WarrantyPostgrestAdapter implements ListWarrantyPort {
    private final WarrantyPostgresRepository warrantyPostgresRepository;
    private final WarrantyPostgresMapper warrantyPostgresMapper;

    @Override
    public List<WarrantyDomain> findAll() {
        List<WarrantyEntity> warranties = this.warrantyPostgresRepository.findAll();
        return this.warrantyPostgresMapper.toDomains(warranties);
    }
}
