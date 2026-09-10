package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.entity.JewelleryItem;

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
         }

}
