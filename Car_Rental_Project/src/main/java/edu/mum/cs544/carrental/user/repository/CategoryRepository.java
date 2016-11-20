package edu.mum.cs544.carrental.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.carrental.user.domain.Category;


@Repository
public interface CategoryRepository extends  CrudRepository<Category, Long>{
		
}
