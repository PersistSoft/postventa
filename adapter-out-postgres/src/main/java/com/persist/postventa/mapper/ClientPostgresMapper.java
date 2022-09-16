package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ClientEntity;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientPostgresMapper extends BaseMapper<ClientEntity, ClientDomain> {
}
