package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ApartmentEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApartmentPostgresMapper extends BaseMapper<ApartmentEntity, ApartmentDomain> {
}
