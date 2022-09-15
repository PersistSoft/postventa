package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.ProjectDomain;
import com.persist.postventa.ports.in.ListProjectUseCase;
import com.persist.postventa.ports.out.ListProjectPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "projectService")
public class ProjectService implements ListProjectUseCase {
    private final ListProjectPort listProjectPort;

    @Override
    public List<ProjectDomain> findAll() {
        return this.listProjectPort.findAll();
    }
}
