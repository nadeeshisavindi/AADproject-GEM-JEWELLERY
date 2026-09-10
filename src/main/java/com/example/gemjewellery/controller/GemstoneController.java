package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.entity.GemCertificate;
import com.example.gemjewellery.entity.GemInventory;
import com.example.gemjewellery.entity.Gemstone;
import com.example.gemjewellery.entity.GemValuation;
import com.example.gemjewellery.exception.AppException;
import com.example.gemjewellery.repository.GemCertificateRepository;
import com.example.gemjewellery.repository.GemInventoryRepository;
import com.example.gemjewellery.repository.GemValuationRepository;
import com.example.gemjewellery.repository.GemstoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Gemstones plus their three "detail" tables: certificate, valuation and
 * inventory. Kept in one controller since they are all part of the same
 * screen in the frontend (view/edit a gemstone).
 */
@RestController
@RequestMapping("/v1/gemstones")
@CrossOrigin
@RequiredArgsConstructor
public class GemstoneController {

    private final GemstoneRepository gemstoneRepository;
    private final GemCertificateRepository certificateRepository;
    private final GemValuationRepository valuationRepository;
    private final GemInventoryRepository inventoryRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAll() {
        return new CommonResponse(0, gemstoneRepository.findAll(), "Gemstones");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getOne(@PathVariable Long id) {
       }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse create(@RequestBody Gemstone gemstone) {
        }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse update(@RequestBody Gemstone gemstone) {
       }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse delete(@PathVariable Long id) {
        gemstoneRepository.deleteById(id);
        return new CommonResponse(0, "Gemstone deleted");
    }

    // ---- Certificate (1-1 with gemstone) ----
    @PostMapping(value = "/certificate", produces = MediaType.APPLICATION_JSON_VALUE)
    }

    @GetMapping(value = "/certificates", produces = MediaType.APPLICATION_JSON_VALUE)
   }


    @PostMapping(value = "/valuation", produces = MediaType.APPLICATION_JSON_VALUE)
    }

    @GetMapping(value = "/valuations", produces = MediaType.APPLICATION_JSON_VALUE)
    }



}
