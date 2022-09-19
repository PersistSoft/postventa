package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SocietyPostgresMapper extends BaseMapper<SocietyEntity, SocietyDomain> {
    List<SocietyDomain> toDomains(List<SocietyEntity> e);
}
