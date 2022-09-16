package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.ApartmentEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.mapper.ApartmentPostgresMapper;
import com.persist.postventa.ports.out.ListApartmentPort;
import com.persist.postventa.springdata.ApartmentPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "apartmentPostgresAdapter")
public class ApartmentPostgresAdapter implements ListApartmentPort {
    private final ApartmentPostgresRepository apartmentPostgresRepository;
    private final ApartmentPostgresMapper apartmentPostgresMapper;

    @Override
    public List<ApartmentDomain> findAll() {
        List<ApartmentEntity> apartments = this.apartmentPostgresRepository.findAll();
        return this.apartmentPostgresMapper.toDomains(apartments);
    }
}
