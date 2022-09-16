package com.persist.postventa.rest.response;

import com.persist.postventa.rest.enums.CodeResponseEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse {
    private CodeResponseEnum code;
    private Object message;
}
