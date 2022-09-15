package com.persist.postventa.springdata;

import com.persist.postventa.entity.generic.SocietyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocietyPostgresRepository extends GenericPostgresRepository<SocietyEntity, Long> {
    @Query(value = "select society.* from societies society", nativeQuery = true)
    List<SocietyEntity> getAll();
}
