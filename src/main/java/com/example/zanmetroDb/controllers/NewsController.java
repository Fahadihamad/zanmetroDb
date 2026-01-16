package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.News;
import com.example.zanmetroDb.Services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService service;

    @PostMapping
    public News create(@RequestBody News e){ return service.save(e); }
    @PutMapping("/{id}") public News update(@PathVariable Long id, @RequestBody News e){ e.setId(id); return service.update(e); }
    @GetMapping("/{id}") public News getById(@PathVariable Long id){ return service.findById(id); }
    @GetMapping public List<News> getAll(){ return service.findAll(); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

