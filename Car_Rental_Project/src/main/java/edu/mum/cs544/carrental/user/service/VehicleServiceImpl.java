package edu.mum.cs544.carrental.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.carrental.user.domain.Vehicle;
import edu.mum.cs544.carrental.user.repository.VehicleRepository;

@Service
@Transactional

public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;

	

	@Override
	public Vehicle getVehicleById(Long key) {
		return vehicleRepository.findOne(key);
	}

	
	@Override
	public void delete(Long id) {
		vehicleRepository.delete(id);
		
	}

	
	@Override
	public List<Vehicle> getAll() {
		
		return (List<Vehicle>) vehicleRepository.findAll();
	}


	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		
	}


	


}
