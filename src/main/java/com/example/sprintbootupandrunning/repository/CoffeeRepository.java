package com.example.sprintbootupandrunning.repository;

import com.example.sprintbootupandrunning.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
