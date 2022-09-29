package com.persist.postventa.rest;

import com.persist.postventa.annotations.WebAPIRESTAdaptar;
import com.persist.postventa.commons.APIEndPointConst;
import com.persist.postventa.commons.APIMessageConst;
import com.persist.postventa.generic.WarrantyDomain;
import com.persist.postventa.ports.in.warranty.ListWarrantyUseCase;
import com.persist.postventa.ports.in.warranty.NewWarrantyEventUseCase;
import com.persist.postventa.ports.in.warranty.SaveWarrantyUseCase;
import com.persist.postventa.ports.in.warranty.WarrantyCommand;
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
@WebAPIRESTAdaptar(value = "warranties")
@RequestMapping(APIEndPointConst.API_WARRANTIES)
public class WarrantyRest {
    private final ListWarrantyUseCase listWarrantyUseCase;
    private final SaveWarrantyUseCase  saveWarrantyUseCase;
    private final NewWarrantyEventUseCase newWarrantyEventUseCase;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("{} findAll", SocietyRest.class.getSimpleName());
        try {
            List<WarrantyDomain> warranties = this.listWarrantyUseCase.findAll();
            if(isNull(warranties) || warranties.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(warranties);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody WarrantyCommand warrantyCommand) {
        WarrantyDomain warranty = this.saveWarrantyUseCase.save(warrantyCommand);
        this.newWarrantyEventUseCase.newWarrantyEvent(warranty);
        return ResponseEntity.ok(warranty);
    }
}
