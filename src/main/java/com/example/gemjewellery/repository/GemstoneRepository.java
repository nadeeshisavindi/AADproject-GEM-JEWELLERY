package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.Gemstone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemstoneRepository extends JpaRepository<Gemstone, Long> {
    boolean existsByGemCode(String gemCode);
}
