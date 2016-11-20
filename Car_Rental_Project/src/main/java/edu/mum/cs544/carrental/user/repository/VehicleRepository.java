package edu.mum.cs544.carrental.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.carrental.user.domain.Vehicle;

@Repository
public interface VehicleRepository extends  CrudRepository<Vehicle, Long>{

	
	
	

}
