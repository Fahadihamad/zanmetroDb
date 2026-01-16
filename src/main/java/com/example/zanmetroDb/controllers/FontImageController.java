package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.FontImage;
import com.example.zanmetroDb.Services.FontImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/font-images")
@RequiredArgsConstructor
public class FontImageController {

    private final FontImageService service;

    // Add new FontImage
    @PostMapping
    public FontImage create(@RequestBody FontImage fontImage) {
        return service.save(fontImage);
    }

    // Update existing FontImage
    @PutMapping("/{id}")
    public FontImage update(@PathVariable Long id, @RequestBody FontImage fontImage) {
        fontImage.setId(id); // Ensure the ID is set
        return service.update(fontImage);
    }

    // Get FontImage by ID
    @GetMapping("/{id}")
    public FontImage getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // Get all FontImages
    @GetMapping
    public List<FontImage> getAll() {
        return service.findAll();
    }

    // Delete FontImage by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

