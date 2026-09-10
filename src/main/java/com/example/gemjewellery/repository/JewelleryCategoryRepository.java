package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.JewelleryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelleryCategoryRepository extends JpaRepository<JewelleryCategory, Long> {
}
