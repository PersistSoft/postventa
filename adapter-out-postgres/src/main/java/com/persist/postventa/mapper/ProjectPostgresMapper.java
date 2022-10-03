package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ProjectEntity;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.ProjectDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectPostgresMapper extends BaseMapper<ProjectEntity, ProjectDomain> {
    ProjectDomain toDomain(ProjectEntity e);
    ProjectEntity toEntity(ApartmentDomain D);
    List<ProjectDomain> toDomains(List<ProjectEntity> e);
    List<ProjectEntity> toEntities(List<ProjectDomain> d);
}
