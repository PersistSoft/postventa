package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.entity.generic.ApartmentEntity;
import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.ApartmentPostgresMapper;
import com.persist.postventa.ports.out.apartment.FindApartmentByIdPort;
import com.persist.postventa.ports.out.apartment.ListApartmentPort;
import com.persist.postventa.springdata.ApartmentPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "apartmentPostgresAdapter")
public class ApartmentPostgresAdapter implements ListApartmentPort, FindApartmentByIdPort {
    private final ApartmentPostgresRepository apartmentPostgresRepository;
    private final ApartmentPostgresMapper apartmentPostgresMapper;

    @Override
    public List<ApartmentDomain> findAll() {
        List<ApartmentEntity> apartments = this.apartmentPostgresRepository.findAll();
        return this.apartmentPostgresMapper.toDomains(apartments);
    }

    public ApartmentDomain findById(Long id) {
        Optional<ApartmentEntity> optApartment = this.apartmentPostgresRepository.findById(id);

        if(optApartment.isPresent()){
            return this.apartmentPostgresMapper.toDomain(optApartment.get());
        }

        return null;
    }
}
