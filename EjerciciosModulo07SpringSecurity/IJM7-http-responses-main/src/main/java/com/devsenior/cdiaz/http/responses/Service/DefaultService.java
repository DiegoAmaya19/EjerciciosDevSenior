package com.devsenior.cdiaz.http.responses.Service;

import org.springframework.stereotype.Service;
import com.devsenior.cdiaz.http.responses.dto.SumaResponse;

@Service
public class DefaultService {
    public SumaResponse suma(String num1, String num2) {
        var responseBuilder = SumaResponse.builder();

        responseBuilder
                .isError(false)
                .value(Integer.valueOf(num1) + Integer.valueOf(num2));

        return responseBuilder.build();
    }
}