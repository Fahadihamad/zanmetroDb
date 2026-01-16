package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Alumni;
import com.example.zanmetroDb.Services.AlumniService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
@RequiredArgsConstructor
public class AlumniController {
    private final AlumniService service;

    @PostMapping
    public Alumni create(@RequestBody Alumni e){ return service.save(e); }
    @PutMapping("/{id}") public Alumni update(@PathVariable Long id, @RequestBody Alumni e){ e.setId(id); return service.update(e); }
    @GetMapping("/{id}") public Alumni getById(@PathVariable Long id){ return service.findById(id); }
    @GetMapping public List<Alumni> getAll(){ return service.findAll(); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

