package com.example.carshop.service;

import com.example.carshop.controller.dto.CarDto;
import com.example.carshop.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCar() throws Exception;
    Car getById(Long id) throws Exception;
    Car createCarName(CarDto carDTO) throws Exception;
    Car updateCarName(Long id, CarDto carDTO) throws Exception;
    void deleteCarName(Long id);
}
