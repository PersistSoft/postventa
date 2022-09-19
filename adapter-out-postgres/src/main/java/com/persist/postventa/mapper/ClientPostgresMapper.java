package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ClientEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientPostgresMapper extends BaseMapper<ClientEntity, ClientDomain> {
    ClientDomain toDomain(ClientEntity e);
    ClientEntity toEntity(ApartmentDomain D);
    List<ClientDomain> toDomains(List<ClientEntity> e);
    List<ClientEntity> toEntities(List<ClientDomain> d);
}
