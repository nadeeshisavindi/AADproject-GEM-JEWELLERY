package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.entity.GemColor;
import com.example.gemjewellery.entity.GemOrigin;
import com.example.gemjewellery.entity.GemType;
import com.example.gemjewellery.entity.JewelleryCategory;
import com.example.gemjewellery.entity.Supplier;
import com.example.gemjewellery.repository.GemColorRepository;
import com.example.gemjewellery.repository.GemOriginRepository;
import com.example.gemjewellery.repository.GemTypeRepository;
import com.example.gemjewellery.repository.JewelleryCategoryRepository;
import com.example.gemjewellery.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ReferenceDataController {

    private final GemTypeRepository gemTypeRepository;
    private final GemColorRepository gemColorRepository;
    private final GemOriginRepository gemOriginRepository;
    private final JewelleryCategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;


    @GetMapping(value = "/v1/gem-types", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getGemTypes() {
        return new CommonResponse(0, gemTypeRepository.findAll(), "Gem types");
    }

    @PostMapping(value = "/v1/gem-types", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addGemType(@RequestBody GemType gemType) {
      }

}
