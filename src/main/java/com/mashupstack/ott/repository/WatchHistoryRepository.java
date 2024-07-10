package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchHistoryRepository extends JpaRepository<WatchHistory, Long> {
    //List<WatchHistory> findByUserId(Long userId);

    List<WatchHistory> findByEmail(String userEmail);

    //List<WatchHistory> findByUserId(long id);
}
