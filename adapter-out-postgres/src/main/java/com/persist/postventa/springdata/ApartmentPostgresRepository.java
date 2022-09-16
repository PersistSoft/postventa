package com.persist.postventa.springdata;

import com.persist.postventa.entity.generic.ApartmentEntity;
import com.persist.postventa.springdata.generic.GenericPostgresRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentPostgresRepository extends GenericPostgresRepository<ApartmentEntity, Long> {
}
