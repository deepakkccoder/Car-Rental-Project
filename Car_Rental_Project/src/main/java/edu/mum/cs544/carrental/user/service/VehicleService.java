package edu.mum.cs544.carrental.user.service;

import java.util.List;

import edu.mum.cs544.carrental.user.domain.Vehicle;

public interface VehicleService {
	public List <Vehicle> getAll();
	public Vehicle getVehicleById(Long key);
	public void delete(Long id);
	public void addVehicle(Vehicle product);
	
	


}
