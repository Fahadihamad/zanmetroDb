package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Header;
import com.example.zanmetroDb.Repository.HeaderRepository;
import com.example.zanmetroDb.dto.HeaderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeaderService {

    private final HeaderRepository repository;

    public HeaderDto save(HeaderDto dto) {
        Header h = new Header();
        h.setParagraph(dto.getParagraph());
        return toDto(repository.save(h));
    }

    public HeaderDto update(HeaderDto dto) {
        Header existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setParagraph(dto.getParagraph());
        return toDto(repository.save(existing));
    }

    public HeaderDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<HeaderDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private HeaderDto toDto(Header h) {
        return new HeaderDto(h.getId(), h.getParagraph());
    }
}
