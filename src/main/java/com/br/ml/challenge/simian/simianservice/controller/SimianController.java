package com.br.ml.challenge.simian.simianservice.controller;

import com.br.ml.challenge.simian.simianservice.dto.DnaChainRequest;
import com.br.ml.challenge.simian.simianservice.dto.ResearchStatus;
import com.br.ml.challenge.simian.simianservice.usecase.research.GetResearchStats;
import com.br.ml.challenge.simian.simianservice.usecase.simian.IsSimian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimianController {

    private IsSimian isSimian;

    private GetResearchStats getResearchStats;

    @Autowired
    public SimianController(IsSimian isSimian, GetResearchStats getResearchStats) {
        this.isSimian = isSimian;
        this.getResearchStats = getResearchStats;
    }

    @PostMapping("/simian")
    public ResponseEntity<Boolean> isSimian(@RequestBody DnaChainRequest request) {

        //validar antes se matriz é quadrada e se contem apenas A C G T

        Boolean isSimian = this.isSimian.execute(request.getDna());

        if(isSimian) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }

        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/stats")
    public ResponseEntity<ResearchStatus> getResearchStats() {

        return new ResponseEntity<>(getResearchStats.execute(), HttpStatus.OK);
    }
}
