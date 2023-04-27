package com.example.carshop.repository;

import com.example.carshop.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByCar_Id(Long carId);
}
