package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Alumni;
import com.example.zanmetroDb.Services.AlumniService;
import com.example.zanmetroDb.dto.AlumniDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
@RequiredArgsConstructor
public class AlumniController {

    private final AlumniService service;

    @PostMapping
    public AlumniDto create(@RequestBody AlumniDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public AlumniDto update(@PathVariable Long id, @RequestBody AlumniDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public AlumniDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<AlumniDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


