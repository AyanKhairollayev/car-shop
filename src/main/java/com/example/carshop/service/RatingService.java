package com.example.carshop.service;

import com.example.carshop.controller.dto.RatingDto;
import com.example.carshop.model.Rating;

import java.util.List;

public interface RatingService {
    Rating addRating(RatingDto ratingDTO) throws Exception;
    List<Rating> getRatingsForEntity(Long carId) throws Exception;
    List<Rating> getAllRatings() throws Exception;
    Double calculateAverageRating(Long carId) throws Exception;
    void delete(Long id);
}
