package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SocietyPostgresMapper extends BaseMapper<SocietyEntity, SocietyDomain> {

    //@Mapping(source = "societyEntity.id", target = "id")
    //@Mapping(source = "societyEntity.name", target = "name")
    //@Mapping(source = "societyEntity.nit", target = "nit")
    List<SocietyDomain> toDomains(List<SocietyEntity> societyEntity);

    //@Mapping(source = "societyDomain.id", target = "id")
    //@Mapping(source = "societyDomain.name", target = "name")
    //@Mapping(source = "societyDomain.nit", target = "nit")
    List<SocietyEntity> toEntities(List<SocietyDomain> societyDomain);
}
