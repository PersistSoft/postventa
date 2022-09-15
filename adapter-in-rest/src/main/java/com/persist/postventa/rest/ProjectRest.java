package com.persist.postventa.rest;

import com.persist.postventa.annotations.WebAPIRESTAdaptar;
import com.persist.postventa.commons.APIEndPointConst;
import com.persist.postventa.commons.APIMessageConst;
import com.persist.postventa.generic.ProjectDomain;
import com.persist.postventa.ports.in.ListProjectUseCase;
import com.persist.postventa.rest.enums.CodeResponseEnum;
import com.persist.postventa.rest.response.CustomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequiredArgsConstructor
@WebAPIRESTAdaptar(value = "projectRest")
@RequestMapping(APIEndPointConst.API_PROJECT)
public class ProjectRest {
    private final ListProjectUseCase listProjectUseCase;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("{} findAll", SocietyRest.class.getSimpleName());
        try {
            List<ProjectDomain> projects = this.listProjectUseCase.findAll();
            if(isNull(projects) || projects.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(projects);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }
}
