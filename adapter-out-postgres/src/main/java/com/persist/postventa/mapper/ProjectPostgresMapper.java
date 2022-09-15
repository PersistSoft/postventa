package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ProjectEntity;
import com.persist.postventa.generic.ProjectDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectPostgresMapper extends BaseMapper<ProjectEntity, ProjectDomain>{

    @Mapping(source = "projectEntity.id", target = "id")
    @Mapping(source = "projectEntity.name", target = "name")
    @Mapping(source = "projectEntity.address", target = "address")
    @Mapping(source = "projectEntity.society", target = "society")
    List<ProjectDomain> toDomains(List<ProjectEntity> projectEntity);
}
