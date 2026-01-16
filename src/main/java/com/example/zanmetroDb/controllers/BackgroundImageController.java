package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.BackgroundImage;
import com.example.zanmetroDb.Services.BackgroundImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/background-images")
@RequiredArgsConstructor
public class BackgroundImageController {
    private final BackgroundImageService service;

    @PostMapping
    public BackgroundImage create(@RequestBody BackgroundImage e){ return service.save(e); }
    @PutMapping("/{id}") public BackgroundImage update(@PathVariable Long id, @RequestBody BackgroundImage e){
        e.setId(id);
        return service.update(e);
    }
    @GetMapping("/{id}") public BackgroundImage getById(@PathVariable Long id){ return service.findById(id); }
    @GetMapping public List<BackgroundImage> getAll(){ return service.findAll(); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

