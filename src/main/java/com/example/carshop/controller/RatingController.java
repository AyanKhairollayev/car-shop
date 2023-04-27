package com.example.carshop.controller;

import com.example.carshop.dto.RatingDto;
import com.example.carshop.model.Rating;
import com.example.carshop.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("api/rating/addrate")
    public ResponseEntity<?> addRating(@RequestBody RatingDto ratingDTO) throws Exception {
        Double value = ratingService.addRating(ratingDTO).getRatingValue();
        return ResponseEntity.ok().body("Rating added - " + value);
    }

    @GetMapping("api/rating/getavgrate/{carId}")
    public Double calculateAverageRating(@PathVariable Long carId) throws Exception {
        return ratingService.calculateAverageRating(carId);
    }

    @DeleteMapping("api/rating/delrate/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        ratingService.delete(id);
        return ResponseEntity.ok().body("Rating deleted");
    }

    @GetMapping("api/ratings")
    public List<Rating> getAllRatings() throws Exception{
        return ratingService.getAllRatings();
    }

    @GetMapping("api/rating/getrating/{carId}")
    public List<Rating> getRatingsForEntity(@PathVariable Long carId) throws Exception {
        return ratingService.getRatingsForEntity(carId);
    }
}
