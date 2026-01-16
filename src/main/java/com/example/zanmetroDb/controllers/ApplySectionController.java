package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.ApplySection;
import com.example.zanmetroDb.Services.ApplySectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apply-sections")
@RequiredArgsConstructor
public class ApplySectionController {
    private final ApplySectionService service;

    @PostMapping
    public ApplySection create(@RequestBody ApplySection e){ return service.save(e); }
    @PutMapping("/{id}") public ApplySection update(@PathVariable Long id, @RequestBody ApplySection e){ e.setId(id); return service.update(e); }
    @GetMapping("/{id}") public ApplySection getById(@PathVariable Long id){ return service.findById(id); }
    @GetMapping public List<ApplySection> getAll(){ return service.findAll(); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

