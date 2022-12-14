package com.persist.postventa.rest;

import com.persist.postventa.annotations.WebAPIRESTAdaptar;
import com.persist.postventa.commons.APIEndPointConst;
import com.persist.postventa.commons.APIMessageConst;
import com.persist.postventa.generic.ApartmentDomain;
import com.persist.postventa.generic.SocietyDomain;
import com.persist.postventa.ports.in.apartment.FindApartmentByIdUseCase;
import com.persist.postventa.ports.in.apartment.ListApartmentUseCase;
import com.persist.postventa.rest.enums.CodeResponseEnum;
import com.persist.postventa.rest.response.CustomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequiredArgsConstructor
@WebAPIRESTAdaptar(value = "apartmentRest")
@RequestMapping(APIEndPointConst.API_APARTMENT)
public class ApartmentRest {
    private final ListApartmentUseCase listApartmentUseCase;
    private final FindApartmentByIdUseCase findApartmentByIdUseCase;

    @GetMapping
    public ResponseEntity<?> findAll(){
        log.info("{} findAll", SocietyRest.class.getSimpleName());
        try {
            List<ApartmentDomain> apartments = this.listApartmentUseCase.findAll();
            if(isNull(apartments) || apartments.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(apartments);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBbyId(@PathVariable Long id ){
        try {

            ApartmentDomain apartment = this.findApartmentByIdUseCase.findById(id);

            if(isNull(apartment)) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(apartment);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(CustomResponse.builder().code(CodeResponseEnum.ERROR)
                            .message(APIMessageConst.MSG_INTERNAL_SERVER_ERROR).build());
        }
    }
}
