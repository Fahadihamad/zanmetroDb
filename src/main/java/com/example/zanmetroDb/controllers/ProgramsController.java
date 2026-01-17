package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Programs;
import com.example.zanmetroDb.Services.ProgramsService;
import com.example.zanmetroDb.dto.ProgramsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
public class ProgramsController {

    private final ProgramsService service;

    @PostMapping
    public ProgramsDto create(@RequestBody ProgramsDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ProgramsDto update(@PathVariable Long id, @RequestBody ProgramsDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public ProgramsDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ProgramsDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}


