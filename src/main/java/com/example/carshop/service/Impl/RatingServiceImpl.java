package com.example.carshop.service.Impl;

import com.example.carshop.controller.dto.RatingDto;
import com.example.carshop.model.Rating;
import com.example.carshop.repository.RatingRepository;
import com.example.carshop.service.CarService;
import com.example.carshop.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    private final CarService carService;

    @Override
    public Rating addRating(RatingDto ratingDTO) throws Exception {
        Rating rating = new Rating();
        rating.setRatingValue(ratingDTO.getRatingValue());
        rating.setCar(carService.getById(ratingDTO.getCarId()));
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingsForEntity(Long carId) throws Exception {
        return ratingRepository.findAllByCar_Id(carId);
    }

    @Override
    public List<Rating> getAllRatings() throws Exception {
        return ratingRepository.findAll();
    }

    @Override
    public Double calculateAverageRating(Long carId) throws Exception {
        List<Rating> ratings = getRatingsForEntity(carId);
        if (ratings.isEmpty()){
            return 0.0;
        }
        double sum = ratings.stream().mapToDouble(Rating::getRatingValue).sum();
        return sum / ratings.size();
    }

    @Override
    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }
}
