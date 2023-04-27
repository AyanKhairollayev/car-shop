package com.example.carshop.service.Impl;

import com.example.carshop.dto.CarDto;
import com.example.carshop.model.Car;
import com.example.carshop.repository.CarRepository;
import com.example.carshop.service.CarService;
import com.example.carshop.service.ManufService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ManufService manufService;

    @Override
    public Car createCarName(CarDto carDTO) throws Exception {
        Car car = new Car();
        car.setName(carDTO.getName());
        car.setCarIssue(carDTO.getYear());
        car.setManufacturer(manufService.getById(carDTO.getManufacturerId()));
        return carRepository.save(car);
    }

    @Override
    public Car updateCarName(Long id, CarDto carDTO) throws Exception {
        Car car = carRepository.findById(id).orElseThrow();
        if (id != null) {
            car.setName(carDTO.getName());
            car.setCarIssue(carDTO.getYear());
            car.setManufacturer(manufService.getById(carDTO.getManufacturerId()));
        }
        return carRepository.save(car);
    }

    @Override
    public void deleteCarName(Long id){
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getAllCar() throws Exception {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }
}
