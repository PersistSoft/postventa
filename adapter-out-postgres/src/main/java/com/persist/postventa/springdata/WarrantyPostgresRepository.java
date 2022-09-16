package com.persist.postventa.springdata;

import com.persist.postventa.entity.generic.WarrantyEntity;
import com.persist.postventa.springdata.generic.GenericPostgresRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarrantyPostgresRepository extends GenericPostgresRepository<WarrantyEntity, Long> {
}
