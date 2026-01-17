package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Counter;
import com.example.zanmetroDb.Services.CounterService;
import com.example.zanmetroDb.dto.CounterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counters")
@RequiredArgsConstructor
public class CounterController {

    private final CounterService service;

    // CREATE
    @PostMapping
    public CounterDto create(@RequestBody CounterDto dto) {
        return service.save(dto);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CounterDto update(@PathVariable Long id, @RequestBody CounterDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CounterDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // GET ALL
    @GetMapping
    public List<CounterDto> getAll() {
        return service.findAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
