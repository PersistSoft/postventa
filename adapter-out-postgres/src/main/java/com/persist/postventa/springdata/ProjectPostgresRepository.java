package com.persist.postventa.springdata;

import com.persist.postventa.entity.generic.ProjectEntity;
import com.persist.postventa.springdata.generic.GenericPostgresRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectPostgresRepository extends GenericPostgresRepository<ProjectEntity, Long> {
    @Query(value = "select project.* from projects project", nativeQuery = true)
    List<ProjectEntity> getAll();
}
