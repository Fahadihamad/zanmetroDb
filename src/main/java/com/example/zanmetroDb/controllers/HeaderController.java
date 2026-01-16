package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Header;
import com.example.zanmetroDb.Services.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/headers")
@RequiredArgsConstructor
public class HeaderController {
    private final HeaderService service;

    @PostMapping
    public Header create(@RequestBody Header h){
        return service.save(h); }
    @PutMapping("/{id}") public Header update(@PathVariable Long id, @RequestBody Header h){
        h.setId(id);
        return service.update(h);
    }
    @GetMapping("/{id}") public Header getById(@PathVariable Long id){
        return service.findById(id); }
    @GetMapping public List<Header> getAll(){
        return service.findAll(); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){
        service.delete(id); }
}

