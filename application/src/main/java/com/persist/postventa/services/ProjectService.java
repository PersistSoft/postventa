package com.persist.postventa.services;

import com.persist.postventa.annotations.UseCase;
import com.persist.postventa.generic.ProjectDomain;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.project.ListProjectUseCase;
import com.persist.postventa.ports.in.project.SaveProjectUseCase;
import com.persist.postventa.ports.in.project.ProjectCommand;
import com.persist.postventa.ports.out.project.ListProjectPort;
import com.persist.postventa.ports.out.project.SaveProjectPort;
import com.persist.postventa.ports.out.society.FindSocietyByIdPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@UseCase(value = "projectService")
public class ProjectService implements ListProjectUseCase, SaveProjectUseCase {
    private final ListProjectPort listProjectPort;
    private final SaveProjectPort saveProjectPort;
    private final FindSocietyByIdPort findSocietyByIdPort;

    @Override
    public List<ProjectDomain> findAll() {
        return this.listProjectPort.findAll();
    }

    @Override
    public ProjectDomain save(ProjectCommand projectCommand) {
        SocietyDomain society = this.findSocietyByIdPort.findById(projectCommand.getSocietyId());

        ProjectDomain projectDomain = ProjectDomain.builder()
                .name(projectCommand.getName())
                .address(projectCommand.getAddress())
                .society(society)
                .build();
        return this.saveProjectPort.save(projectDomain);
    }
}
