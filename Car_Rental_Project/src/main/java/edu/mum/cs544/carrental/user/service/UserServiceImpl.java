package edu.mum.cs544.carrental.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.carrental.user.domain.Customer;
import edu.mum.cs544.carrental.user.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Customer> getAll() {
		return (List<Customer>)userRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long key) {
		return userRepository.findOne(key);
	}

	@Override
	public void add(Customer customer) {
		userRepository.save(customer);
		
		
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
		
	}

}
