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

    @DeleteMapping(value = "/v1/gem-types/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteGemType(@PathVariable Long id) {

    }


    @GetMapping(value = "/v1/gem-colors", produces = MediaType.APPLICATION_JSON_VALUE)
   }

    @PostMapping(value = "/v1/gem-colors", produces = MediaType.APPLICATION_JSON_VALUE)
    }

    @DeleteMapping(value = "/v1/gem-colors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteGemColor(@PathVariable Long id) {
      }


    @GetMapping(value = "/v1/gem-origins", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getGemOrigins() {
    }

    @PostMapping(value = "/v1/gem-origins", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addGemOrigin(@RequestBody GemOrigin gemOrigin) {
    }

    @DeleteMapping(value = "/v1/gem-origins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteGemOrigin(@PathVariable Long id) {


    @GetMapping(value = "/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getCategories() {
        return new CommonResponse(0, categoryRepository.findAll(), "Jewellery categories");
    }

    @PostMapping(value = "/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
   }

    @DeleteMapping(value = "/v1/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteCategory(@PathVariable Long id) {
         }


    @GetMapping(value = "/v1/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getSuppliers() {
     }

    @PostMapping(value = "/v1/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addSupplier(@RequestBody Supplier supplier) {
    }
}
