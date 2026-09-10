package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.GemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemTypeRepository extends JpaRepository<GemType, Long> {
}
