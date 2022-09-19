package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SocietyPostgresMapper extends BaseMapper<SocietyEntity, SocietyDomain> {
    SocietyDomain toDomain(SocietyEntity e);
    SocietyEntity toEntity(ApartmentDomain D);
    List<SocietyDomain> toDomains(List<SocietyEntity> e);
    List<SocietyEntity> toEntities(List<SocietyDomain> d);
}
