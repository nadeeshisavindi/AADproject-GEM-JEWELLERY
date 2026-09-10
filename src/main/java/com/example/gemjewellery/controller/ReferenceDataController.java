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
        return new CommonResponse(0, gemTypeRepository.save(gemType), "Gem type saved");
    }

    @DeleteMapping(value = "/v1/gem-types/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteGemType(@PathVariable Long id) {
        gemTypeRepository.deleteById(id);
        return new CommonResponse(0, "Gem type deleted");
    }


    @GetMapping(value = "/v1/gem-colors", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getGemColors() {
        return new CommonResponse(0, gemColorRepository.findAll(), "Gem colors");
    }

    @PostMapping(value = "/v1/gem-colors", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addGemColor(@RequestBody GemColor gemColor) {
        return new CommonResponse(0, gemColorRepository.save(gemColor), "Gem color saved");
    }

    @DeleteMapping(value = "/v1/gem-colors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteGemColor(@PathVariable Long id) {
        gemColorRepository.deleteById(id);
        return new CommonResponse(0, "Gem color deleted");
    }

    @GetMapping(value = "/v1/gem-origins", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getGemOrigins() {
        return new CommonResponse(0, gemOriginRepository.findAll(), "Gem origins");
    }

    @PostMapping(value = "/v1/gem-origins", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addGemOrigin(@RequestBody GemOrigin gemOrigin) {
        return new CommonResponse(0, gemOriginRepository.save(gemOrigin), "Gem origin saved");
    }

    @DeleteMapping(value = "/v1/gem-origins/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteGemOrigin(@PathVariable Long id) {
        gemOriginRepository.deleteById(id);
        return new CommonResponse(0, "Gem origin deleted");
    }


    @GetMapping(value = "/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getCategories() {
        return new CommonResponse(0, categoryRepository.findAll(), "Jewellery categories");
    }

    @PostMapping(value = "/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addCategory(@RequestBody JewelleryCategory category) {
        return new CommonResponse(0, categoryRepository.save(category), "Category saved");
    }

    @DeleteMapping(value = "/v1/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return new CommonResponse(0, "Category deleted");
    }


    @GetMapping(value = "/v1/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getSuppliers() {
        return new CommonResponse(0, supplierRepository.findAll(), "Suppliers");
    }

    @PostMapping(value = "/v1/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addSupplier(@RequestBody Supplier supplier) {
        return new CommonResponse(0, supplierRepository.save(supplier), "Supplier saved");
    }

    @PutMapping(value = "/v1/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateSupplier(@RequestBody Supplier supplier) {
        return new CommonResponse(0, supplierRepository.save(supplier), "Supplier updated");
    }

    @DeleteMapping(value = "/v1/suppliers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse deleteSupplier(@PathVariable Long id) {
        supplierRepository.deleteById(id);
        return new CommonResponse(0, "Supplier deleted");
    }
}
