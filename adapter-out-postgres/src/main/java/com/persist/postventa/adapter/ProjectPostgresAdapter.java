package com.persist.postventa.adapter;

import com.persist.postventa.annotations.RDBMSPostgresAdapter;
import com.persist.postventa.generic.ProjectDomain;
import com.persist.postventa.mapper.ProjectPostgresMapper;
import com.persist.postventa.ports.out.ListProjectPort;
import com.persist.postventa.springdata.ProjectPostgresRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RDBMSPostgresAdapter(value = "projectPostgresAdapter")
public class ProjectPostgresAdapter implements ListProjectPort {
    private final ProjectPostgresRepository projectPostgresRepository;
    private final ProjectPostgresMapper projectPostgresMapper;

    @Override
    public List<ProjectDomain> findAll() {
        log.info("{} findAll", SocietyPostgresAdapter.class.getSimpleName());
        this.projectPostgresRepository.getAll().stream().forEach(System.out::println);
        var projectDomains
                = this.projectPostgresMapper.toDomains(this.projectPostgresRepository.getAll());
        return projectDomains;
    }
}
