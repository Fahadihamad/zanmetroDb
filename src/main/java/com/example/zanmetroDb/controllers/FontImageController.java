package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.FontImage;
import com.example.zanmetroDb.Services.FontImageService;
import com.example.zanmetroDb.dto.FontImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/font-images")
@RequiredArgsConstructor
public class FontImageController {

    private final FontImageService service;

    @PostMapping
    public FontImageDto create(@RequestBody FontImageDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public FontImageDto update(@PathVariable Long id, @RequestBody FontImageDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public FontImageDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<FontImageDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
