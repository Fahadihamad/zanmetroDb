package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Contacts;
import com.example.zanmetroDb.Services.ContactsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactsController {
    private final ContactsService service;

    @PostMapping
    public Contacts create(@RequestBody Contacts e){ return service.save(e);
    }
    @PutMapping("/{id}") public Contacts update(@PathVariable Long id, @RequestBody Contacts e){
        e.setId(id); return service.update(e); }
    @GetMapping("/{id}") public Contacts getById(@PathVariable Long id){
        return service.findById(id); }
    @GetMapping public List<Contacts> getAll(){ return service.findAll();
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

