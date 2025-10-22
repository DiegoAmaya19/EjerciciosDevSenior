package com.devsenior.cdiaz.http.responses.dto;

public class SumaResponse {
    private Boolean isError;
    private String errorMessage;
    private Integer value;

    public SumaResponse(Boolean isError, String errorMessage, Integer value) {
        this.isError = isError;
        this.errorMessage = errorMessage;
        this.value = value;
    }

    public Boolean getIsError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static SumaResponseBuilder builder() {
        return new SumaResponseBuilder();
    }

    public static class SumaResponseBuilder {
        
        private Boolean isError = null;
        private String errorMessage = null;
        private Integer value = null;

        public SumaResponseBuilder isError(Boolean isError) {
            this.isError = isError;
            return this;
        }

        public SumaResponseBuilder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }
        public SumaResponseBuilder value(Integer value) {
            this.value = value;
            return this;
        }

        public SumaResponse build() {
            return new SumaResponse(isError, errorMessage, value);
        }

    }

}