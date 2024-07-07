package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.Billings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billings, Long> {
}
