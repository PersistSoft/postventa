package com.persist.postventa.rest;

import com.persist.postventa.annotations.WebAPIRESTAdaptar;
import com.persist.postventa.commons.APIEndPointConst;
import com.persist.postventa.commons.APIMessageConst;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.ListSocietyUseCase;
import com.persist.postventa.ports.in.SaveSocietyUseCase;
import com.persist.postventa.ports.in.commands.SocietyCommand;
import com.persist.postventa.rest.enums.CodeResponseEnum;
import com.persist.postventa.rest.response.CustomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequiredArgsConstructor
@WebAPIRESTAdaptar(value = "societyRest")
@RequestMapping(APIEndPointConst.API_SOCIETY)
public class SocietyRest {
    private final ListSocietyUseCase listSocietyUseCase;
    private final SaveSocietyUseCase saveSocietyUseCase;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("{} findAll", SocietyRest.class.getSimpleName());
        try {
            List<SocietyDomain> societies = this.listSocietyUseCase.findAll();
            if(isNull(societies) || societies.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(societies);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SocietyCommand societyCommand){
        log.info("{} save", societyCommand);
        try {

            SocietyDomain society = this.saveSocietyUseCase.save(societyCommand);
            return ResponseEntity.ok(society);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }
}
