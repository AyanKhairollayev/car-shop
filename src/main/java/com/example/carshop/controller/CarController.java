package com.example.carshop.controller;

import com.example.carshop.controller.dto.CarDto;
import com.example.carshop.model.Car;
import com.example.carshop.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/api/carname/create")
    public ResponseEntity<?> createCarName(@RequestBody CarDto carDTO) throws Exception {
        String name = carService.createCarName(carDTO).getName();
        return ResponseEntity.ok().body("Car create - " + name);
    }

    @PutMapping("/api/carname/update/{id}")
    public Car updateCarName(@PathVariable Long id, @RequestBody CarDto carDTO) throws Exception{
        return carService.updateCarName(id, carDTO);
    }

    @DeleteMapping("api/carname/delete/{id}")
    public ResponseEntity<?> deleteCarName(@PathVariable Long id){
        carService.deleteCarName(id);
        return ResponseEntity.ok().body("Car del");
    }

    @GetMapping("api/cars")
    public List<Car> getAll() throws Exception{
        return carService.getAllCar();
    }

    @GetMapping("/api/carname/{id}")
    public Car getById(@PathVariable Long id) throws Exception {
        return carService.getById(id);
    }
}
