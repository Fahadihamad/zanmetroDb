package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Programs;
import com.example.zanmetroDb.Services.ProgramsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
public class ProgramsController {
    private final ProgramsService service;

    @PostMapping
    public Programs create(@RequestBody Programs e){ return service.save(e); }
    @PutMapping("/{id}") public Programs update(@PathVariable Long id, @RequestBody Programs e){ e.setId(id); return service.update(e); }
    @GetMapping("/{id}") public Programs getById(@PathVariable Long id){ return service.findById(id); }
    @GetMapping public List<Programs> getAll(){ return service.findAll(); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

