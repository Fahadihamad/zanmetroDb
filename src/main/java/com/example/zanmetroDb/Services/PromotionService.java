package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Promotion;
import com.example.zanmetroDb.Repository.PromotionRepository;
import com.example.zanmetroDb.dto.PromotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final PromotionRepository repository;

    public PromotionDto save(PromotionDto dto) {
        Promotion e = new Promotion();
        e.setIcon(dto.getIcon());
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        return toDto(repository.save(e));
    }

    public PromotionDto update(PromotionDto dto) {
        Promotion existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setIcon(dto.getIcon());
        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        return toDto(repository.save(existing));
    }

    public PromotionDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<PromotionDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PromotionDto toDto(Promotion e) {
        return new PromotionDto(e.getId(), e.getIcon(), e.getTitle(), e.getDescription());
    }
}


