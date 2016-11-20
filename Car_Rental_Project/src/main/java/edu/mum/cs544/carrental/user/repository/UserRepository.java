package edu.mum.cs544.carrental.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.carrental.user.domain.Customer;


@Repository
public interface UserRepository extends  CrudRepository<Customer, Long> {

}
