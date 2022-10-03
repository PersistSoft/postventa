package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ApartmentEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApartmentPostgresMapper extends BaseMapper<ApartmentEntity, ApartmentDomain> {
    @Mapping(source = "id", target = "id")
    ApartmentDomain toDomain(ApartmentEntity e);
    @Mapping(source = "id", target = "id")
    ApartmentEntity toEntity(ApartmentDomain D);
    List<ApartmentDomain> toDomains(List<ApartmentEntity> e);
    List<ApartmentEntity> toEntities(List<ApartmentDomain> d);
}
