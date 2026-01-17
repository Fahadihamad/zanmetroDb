package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.HeroVideo;
import com.example.zanmetroDb.Services.HeroVideoService;
import com.example.zanmetroDb.dto.HeroVideoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hero-videos")
@RequiredArgsConstructor
public class HeroVideoController {

    private final HeroVideoService service;

    @PostMapping
    public HeroVideoDto create(@RequestBody HeroVideoDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public HeroVideoDto update(@PathVariable Long id, @RequestBody HeroVideoDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public HeroVideoDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<HeroVideoDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


