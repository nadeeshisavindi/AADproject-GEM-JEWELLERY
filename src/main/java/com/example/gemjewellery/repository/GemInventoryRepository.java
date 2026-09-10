package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.GemInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GemInventoryRepository extends JpaRepository<GemInventory, Long> {
}
