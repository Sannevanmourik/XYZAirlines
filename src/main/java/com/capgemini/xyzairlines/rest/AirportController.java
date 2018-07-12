package com.capgemini.xyzairlines.rest;

import com.capgemini.xyzairlines.model.Airport;
import com.capgemini.xyzairlines.persistence.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @PostMapping
    public ResponseEntity<Airport> create(@RequestBody Airport newAirport) {
        Optional<Airport> possibleAirport = this.airportRepository.findById(newAirport.getId());

        if (possibleAirport.isPresent()) {
            Airport existingAirport = possibleAirport.get();
            return new ResponseEntity<Airport>(HttpStatus.CONFLICT);
        }

        else {
            return new ResponseEntity<Airport>((Airport) this.airportRepository.save(newAirport), HttpStatus.CREATED);
        }

    }

    @GetMapping
    public ResponseEntity<Iterable<Airport>> list() {
        return new ResponseEntity<Iterable<Airport>>(this.airportRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Airport> findById(@PathVariable long id) {
        Optional<Airport> possibleAirport = this.airportRepository.findById(id);

        if (possibleAirport.isPresent()) {
            Airport existingAirport = possibleAirport.get();
            return new ResponseEntity<Airport>(existingAirport, HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<Airport> updateById(@PathVariable long id, @RequestBody Airport update) {
        Optional<Airport> possibleAirport = this.airportRepository.findById(id);

        if (possibleAirport.isPresent()) {
            Airport airport = possibleAirport.get();
            airport.setNameOfTheAirport(update.getNameOfTheAirport());
            return new ResponseEntity<Airport>((Airport) this.airportRepository.save(airport), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Airport> deleteById(@PathVariable long id) {
        Optional<Airport> possibleAirport = this.airportRepository.findById(id);

        if (possibleAirport.isPresent()) {
            this.airportRepository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
