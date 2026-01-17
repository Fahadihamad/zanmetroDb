package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Header;
import com.example.zanmetroDb.Services.HeaderService;
import com.example.zanmetroDb.dto.HeaderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/headers")
@RequiredArgsConstructor
public class HeaderController {

    private final HeaderService service;

    @PostMapping
    public HeaderDto create(@RequestBody HeaderDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public HeaderDto update(@PathVariable Long id, @RequestBody HeaderDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public HeaderDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<HeaderDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
