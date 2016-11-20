package edu.mum.cs544.carrental.user.service;

import java.util.List;

import edu.mum.cs544.carrental.user.domain.Customer;



public interface UserService {
	public List<Customer> getAll();
	public Customer getCustomerById(Long key);
	public void add(Customer customer);
	public void delete(Long id);

}
