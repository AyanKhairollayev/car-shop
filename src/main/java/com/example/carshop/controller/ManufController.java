package com.example.carshop.controller;

import com.example.carshop.dto.ManufDto;
import com.example.carshop.model.Manufacturer;
import com.example.carshop.service.ManufService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManufController {
    private final ManufService manufService;

    @PostMapping("api/manufacturer/create")
    public ResponseEntity<?> create(@RequestBody ManufDto manufDTO) {
        String name = manufService.create(manufDTO).getManufName();
        return ResponseEntity.ok().body("Manufacturer created - " + name);
    }

    @PutMapping("api/manufacturer/update/{id}")
    public Manufacturer update(@PathVariable Long id, @RequestBody ManufDto manufDTO){
        return manufService.update(id, manufDTO);
    }

    @DeleteMapping("api/manufacturer/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
         manufService.delete(id);
         return ResponseEntity.ok().body("Manufacturer deleted");
    }

    @GetMapping("api/manufacturers")
    public List<Manufacturer> getAll() throws Exception{
        return manufService.getAllManufacturer();
    }

    @GetMapping("api/manufacturer/{id}")
    public Manufacturer getById(@PathVariable Long id) throws Exception{
        return manufService.getById(id);
    }
}
