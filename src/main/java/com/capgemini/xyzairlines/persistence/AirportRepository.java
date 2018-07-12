package com.capgemini.xyzairlines.persistence;

import com.capgemini.xyzairlines.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {


}
