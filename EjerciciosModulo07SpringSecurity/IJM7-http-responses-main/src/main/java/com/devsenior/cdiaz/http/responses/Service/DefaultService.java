package com.devsenior.cdiaz.http.responses.Service;

import com.devsenior.cdiaz.http.responses.dto.SumaResponse;

public class DefaultService {
    public SumaResponse suma(Integer num1, Integer num2) {
        var responseBuilder = SumaResponse.builder();

        responseBuilder
                .isError(false)
                .value(num1 + num2);

        return responseBuilder.build();
    }
}
