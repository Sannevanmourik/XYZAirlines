package com.capgemini.xyzairlines.rest;

import com.capgemini.xyzairlines.model.Airplaine;
import com.capgemini.xyzairlines.persistence.AirplaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/airplaines")
public class AirplaineController {

    @Autowired
    private AirplaineRepository airplaineRepository;

    @PostMapping
    public ResponseEntity<Airplaine> create(@RequestBody Airplaine newAirplaine) {
        Optional<Airplaine> possibleAirplaine = this.airplaineRepository.findById(newAirplaine.getId());

        if (possibleAirplaine.isPresent()) {
            Airplaine existingAirplaine = possibleAirplaine.get();
            return new ResponseEntity<Airplaine>(HttpStatus.CONFLICT);
        }

        else {
            return new ResponseEntity<Airplaine>(this.airplaineRepository.save(newAirplaine), HttpStatus.CREATED);
        }

    }

    @GetMapping
    public ResponseEntity<Iterable<Airplaine>> list() {
        return new ResponseEntity<Iterable<Airplaine>>(this.airplaineRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Airplaine> findById(@PathVariable long id) {
        Optional<Airplaine> possibleAirplaine = this.airplaineRepository.findById(id);

        if (possibleAirplaine.isPresent()) {
            return new ResponseEntity<Airplaine>(possibleAirplaine.get(), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<Airplaine> updateById(@PathVariable long id, @RequestBody Airplaine update) {
        Optional<Airplaine> possibleAirplaine = this.airplaineRepository.findById(id);

        if (possibleAirplaine.isPresent()) {
            Airplaine airplaine = possibleAirplaine.get();
            airplaine.setStatusOfFuel(update.getStatusOfFuel());
            airplaine.setModel(update.getModel());

            return new ResponseEntity<Airplaine>(this.airplaineRepository.save(airplaine), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Airplaine> deleteById(@PathVariable long id) {
        Optional<Airplaine> possibleAirplaine = this.airplaineRepository.findById(id);

        if (possibleAirplaine.isPresent()) {
            this.airplaineRepository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

}

