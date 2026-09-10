package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.JewelleryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelleryItemRepository extends JpaRepository<JewelleryItem, Long> {
}
