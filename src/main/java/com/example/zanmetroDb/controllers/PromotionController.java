package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Promotion;
import com.example.zanmetroDb.Services.PromotionService;
import com.example.zanmetroDb.dto.PromotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService service;

    @PostMapping
    public PromotionDto create(@RequestBody PromotionDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public PromotionDto update(@PathVariable Long id, @RequestBody PromotionDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public PromotionDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<PromotionDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}



