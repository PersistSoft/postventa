package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.WarrantyEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WarrantyPostgresMapper extends BaseMapper<WarrantyEntity, WarrantyDomain> {
    @Mapping(source = "id", target = "id")
    WarrantyDomain toDomain(WarrantyEntity e);
    @Mapping(source = "id", target = "id")
    WarrantyEntity toEntity(ApartmentDomain D);
    List<WarrantyDomain> toDomains(List<WarrantyEntity> e);
    List<WarrantyEntity> toEntities(List<WarrantyDomain> d);
}
