package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.entity.JewelleryItem;
import com.example.gemjewellery.exception.AppException;
import com.example.gemjewellery.repository.JewelleryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/jewellery-items")
@CrossOrigin
@RequiredArgsConstructor
public class JewelleryItemController {

    private final JewelleryItemRepository jewelleryItemRepository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAll() {
        return new CommonResponse(0, jewelleryItemRepository.findAll(), "Jewellery items");
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getOne(@PathVariable Long id) {
        JewelleryItem item = jewelleryItemRepository.findById(id)
                .orElseThrow(() -> new AppException(404, "Jewellery item not found"));
        return new CommonResponse(0, item, "Jewellery item");
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse create(@RequestBody JewelleryItem item) {
     }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse update(@RequestBody JewelleryItem item) {
        }
          }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse delete(@PathVariable Long id) {
       }
}
