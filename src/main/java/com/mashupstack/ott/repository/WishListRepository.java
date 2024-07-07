package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<Wishlist, Long> {
}
