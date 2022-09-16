package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.WarrantyEntity;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WarrantyPostgresMapper extends BaseMapper<WarrantyEntity, WarrantyDomain> {
}
