package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.SocietyEntity;
import com.persist.postventa.generic.SocietyDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SocietyPostgresMapper extends BaseMapper<SocietyEntity, SocietyDomain>{
}
