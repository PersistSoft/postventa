package com.persist.postventa.springdata;

import com.persist.postventa.entity.generic.ClientEntity;
import com.persist.postventa.springdata.generic.GenericPostgresRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPostgresRepository extends GenericPostgresRepository<ClientEntity, Long> {
}
