package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Ratings, Long> {
}
