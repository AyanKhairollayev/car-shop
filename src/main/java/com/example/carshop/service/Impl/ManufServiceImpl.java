package com.example.carshop.service.Impl;

import com.example.carshop.dto.ManufDto;
import com.example.carshop.model.Manufacturer;
import com.example.carshop.repository.ManufRepository;
import com.example.carshop.service.ManufService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufServiceImpl implements ManufService {
    private final ManufRepository manufRepository;

    @Override
    public Manufacturer create(ManufDto manufDTO) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufName(manufDTO.getName());

        return manufRepository.save(manufacturer);
    }

    @Override
    public Manufacturer update(Long id, ManufDto manufDTO) {
        Manufacturer manufacturer = manufRepository.findById(id).orElseThrow();
        if (id != null) {
            manufacturer.setManufName(manufDTO.getName());
        }
        return manufRepository.save(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufRepository.deleteById(id);
    }


    @Override
    public List<Manufacturer> getAllManufacturer() throws Exception {
        return manufRepository.findAll();
    }

    @Override
    public Manufacturer getById(Long id) {
        return manufRepository.findById(id).orElseThrow();
    }

}
