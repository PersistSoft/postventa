package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ClientEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientPostgresMapper extends BaseMapper<ClientEntity, ClientDomain> {
    @Mapping(source = "id", target = "id")
    ClientDomain toDomain(ClientEntity e);
    @Mapping(source = "id", target = "id")
    ClientEntity toEntity(ApartmentDomain D);
    List<ClientDomain> toDomains(List<ClientEntity> e);
    List<ClientEntity> toEntities(List<ClientDomain> d);
}
