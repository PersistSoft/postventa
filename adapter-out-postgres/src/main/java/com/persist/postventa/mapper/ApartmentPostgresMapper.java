package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ApartmentEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApartmentPostgresMapper extends BaseMapper<ApartmentEntity, ApartmentDomain> {
    ApartmentDomain toDomain(ApartmentEntity e);
    ApartmentEntity toEntity(ApartmentDomain D);
    List<ApartmentDomain> toDomains(List<ApartmentEntity> e);
    List<ApartmentEntity> toEntities(List<ApartmentDomain> d);
}
