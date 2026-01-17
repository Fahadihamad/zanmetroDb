package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.News;
import com.example.zanmetroDb.Services.NewsService;
import com.example.zanmetroDb.dto.NewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService service;

    // CREATE
    @PostMapping
    public NewsDto create(@RequestBody NewsDto dto) {
        return service.save(dto);
    }

    // UPDATE
    @PutMapping("/{id}")
    public NewsDto update(@PathVariable Long id, @RequestBody NewsDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public NewsDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // GET ALL
    @GetMapping
    public List<NewsDto> getAll() {
        return service.findAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
