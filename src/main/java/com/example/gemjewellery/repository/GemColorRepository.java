package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.GemColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemColorRepository extends JpaRepository<GemColor, Long> {
}
