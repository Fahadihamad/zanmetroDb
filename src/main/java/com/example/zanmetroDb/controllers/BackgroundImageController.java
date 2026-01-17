package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.BackgroundImage;
import com.example.zanmetroDb.Services.BackgroundImageService;
import com.example.zanmetroDb.dto.BackgroundImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/background-images")
@RequiredArgsConstructor
public class BackgroundImageController {

    private final BackgroundImageService service;

    @PostMapping
    public BackgroundImageDto create(@RequestBody BackgroundImageDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public BackgroundImageDto update(@PathVariable Long id, @RequestBody BackgroundImageDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public BackgroundImageDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<BackgroundImageDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
