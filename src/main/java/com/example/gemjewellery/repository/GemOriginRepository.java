package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.GemOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemOriginRepository extends JpaRepository<GemOrigin, Long> {
}
