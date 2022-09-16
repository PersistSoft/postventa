package com.persist.postventa.mapper;

import com.persist.postventa.entity.generic.ProjectEntity;
import com.persist.postventa.generic.ProjectDomain;
import com.persist.postventa.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectPostgresMapper extends BaseMapper<ProjectEntity, ProjectDomain> {

    List<ProjectDomain> toDomains(List<ProjectEntity> projectEntity);
}
