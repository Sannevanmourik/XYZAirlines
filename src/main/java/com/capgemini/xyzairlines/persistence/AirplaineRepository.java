package com.capgemini.xyzairlines.persistence;

import com.capgemini.xyzairlines.model.Airplaine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirplaineRepository extends CrudRepository<Airplaine, Long> {


}


