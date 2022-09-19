package com.persist.postventa.rest;

import com.persist.postventa.annotations.WebAPIRESTAdaptar;
import com.persist.postventa.commons.APIEndPointConst;
import com.persist.postventa.commons.APIMessageConst;
import com.persist.postventa.generic.ClientDomain;
import com.persist.postventa.ports.in.client.ListClientUseCase;
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
@WebAPIRESTAdaptar(value = "clients")
@RequestMapping(APIEndPointConst.API_CLIENTS)
public class ClientRest {
    private final ListClientUseCase listClientUseCase;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("{} findAll", SocietyRest.class.getSimpleName());
        try {
            List<ClientDomain> clients = this.listClientUseCase.findAll();
            if(isNull(clients) || clients.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(clients);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }
}
