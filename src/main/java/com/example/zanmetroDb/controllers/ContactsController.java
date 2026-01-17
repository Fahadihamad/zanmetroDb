package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Model.Contacts;
import com.example.zanmetroDb.Services.ContactsService;
import com.example.zanmetroDb.dto.ContactsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactsController {

    private final ContactsService service;

    @PostMapping
    public ContactsDto create(@RequestBody ContactsDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ContactsDto update(@PathVariable Long id, @RequestBody ContactsDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public ContactsDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ContactsDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
