package com.br.ml.challenge.simian.simianservice.usecase.simian;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalInputDNAException extends RuntimeException {

    public IllegalInputDNAException(String message) {
        super(message);
    }
}
