package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.ApplySection;
import com.example.zanmetroDb.Services.ApplySectionService;
import com.example.zanmetroDb.dto.ApplySectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apply-sections")
@RequiredArgsConstructor
public class ApplySectionController {

    private final ApplySectionService service;

    @PostMapping
    public ApplySectionDto create(@RequestBody ApplySectionDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ApplySectionDto update(@PathVariable Long id, @RequestBody ApplySectionDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public ApplySectionDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ApplySectionDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
