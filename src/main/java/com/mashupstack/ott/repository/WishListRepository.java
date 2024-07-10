package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByEmail(String userEmail);
}
