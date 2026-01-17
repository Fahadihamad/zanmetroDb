package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.AboutUs;
import com.example.zanmetroDb.Services.AboutUsService;
import com.example.zanmetroDb.dto.AboutUsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about-us")
@RequiredArgsConstructor
public class AboutUsController {

    private final AboutUsService service;

    @PostMapping
    public AboutUsDto create(@RequestBody AboutUsDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public AboutUsDto update(@PathVariable Long id, @RequestBody AboutUsDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public AboutUsDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<AboutUsDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
