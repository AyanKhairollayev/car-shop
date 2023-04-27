package com.example.carshop.service;

import com.example.carshop.controller.dto.ManufDto;
import com.example.carshop.model.Manufacturer;

import java.util.List;

public interface ManufService {
    List<Manufacturer> getAllManufacturer() throws Exception;
    Manufacturer getById(Long id) throws Exception;
    Manufacturer create(ManufDto manufDTO);
    Manufacturer update(Long id, ManufDto manufDTO);
    void delete(Long id);
}
