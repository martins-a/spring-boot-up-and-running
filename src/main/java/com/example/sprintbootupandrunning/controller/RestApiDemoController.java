package com.example.sprintbootupandrunning.controller;

import com.example.sprintbootupandrunning.model.Coffee;
import com.example.sprintbootupandrunning.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {
//    private List<Coffee> coffees = new ArrayList<>();

    private final CoffeeRepository coffeeRepository;

    public RestApiDemoController(CoffeeRepository coffeeRepository) {

        this.coffeeRepository = coffeeRepository;

    }

    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    Optional<Coffee> getCoffeeByName(@PathVariable String id) {
        return coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {

        coffeeRepository.deleteById(id);
    }

    @PutMapping(value="/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {

        return (!coffeeRepository.existsById(id))
                ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);

    }

}
