package com.br.ml.challenge.simian.simianservice.controller;

import com.br.ml.challenge.simian.simianservice.dto.DnaChainRequest;
import com.br.ml.challenge.simian.simianservice.usecase.simian.IsSimian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimianController {

    private IsSimian isSimian;

    @Autowired
    public SimianController(IsSimian isSimian) {
        this.isSimian = isSimian;
    }

    @PostMapping("/simian")
    public ResponseEntity<Boolean> isSimian(@RequestBody DnaChainRequest request) {

        //validar antes se matriz é quadrada
        return new ResponseEntity<>(isSimian.execute(request.getDna()), HttpStatus.OK);
    }
}
