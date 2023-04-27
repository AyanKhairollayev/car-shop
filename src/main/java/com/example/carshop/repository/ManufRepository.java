package com.example.carshop.repository;

import com.example.carshop.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufRepository extends JpaRepository<Manufacturer, Long> {
}
