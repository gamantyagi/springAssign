package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Location;

public interface LocationRepo extends CrudRepository<Location, Integer> {

}
