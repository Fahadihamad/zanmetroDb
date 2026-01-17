package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.AboutUs;
import com.example.zanmetroDb.Repository.AboutUsRepository;
import com.example.zanmetroDb.dto.AboutUsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutUsService {

    private final AboutUsRepository repository;

    public AboutUsDto save(AboutUsDto dto) {
        AboutUs e = new AboutUs();
        e.setParagraph(dto.getParagraph());
        e.setServices(dto.getServices());
        return toDto(repository.save(e));
    }

    public AboutUsDto update(AboutUsDto dto) {
        AboutUs existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setParagraph(dto.getParagraph());
        existing.setServices(dto.getServices());
        return toDto(repository.save(existing));
    }

    public AboutUsDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<AboutUsDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AboutUsDto toDto(AboutUs e) {
        return new AboutUsDto(e.getId(), e.getParagraph(), e.getServices());
    }
}


