package com.example.zanmetroDb.controllers;

import com.example.zanmetroDb.Services.MessageService;
import com.example.zanmetroDb.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

    @PostMapping
    public MessageDto create(@RequestBody MessageDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public MessageDto update(@PathVariable Long id, @RequestBody MessageDto dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @GetMapping("/{id}")
    public MessageDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<MessageDto> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
