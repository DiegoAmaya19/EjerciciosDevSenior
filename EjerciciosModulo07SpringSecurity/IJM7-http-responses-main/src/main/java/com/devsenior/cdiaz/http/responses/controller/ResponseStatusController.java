package com.devsenior.cdiaz.http.responses.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/response-status")
public class ResponseStatusController {

    @GetMapping("/ok")
    public void getOK() {
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @GetMapping("/created")
    public void getCreated() {
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Es una prueba")
    @GetMapping("/no-content")
    public void getNoContent() {
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @GetMapping("/bad-request")
    public void getBadRequest() {
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @GetMapping("/not-found")
    public void getNotFound() {
    }

}
