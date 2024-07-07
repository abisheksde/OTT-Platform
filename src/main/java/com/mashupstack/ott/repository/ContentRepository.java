package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
