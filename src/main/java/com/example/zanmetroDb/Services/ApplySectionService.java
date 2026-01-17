package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.ApplySection;
import com.example.zanmetroDb.Repository.ApplySectionRepository;
import com.example.zanmetroDb.dto.ApplySectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplySectionService {

    private final ApplySectionRepository repository;

    public ApplySectionDto save(ApplySectionDto dto) {
        ApplySection e = new ApplySection();
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setLeftImage(dto.getLeftImage());
        e.setRightImage(dto.getRightImage());
        return toDto(repository.save(e));
    }

    public ApplySectionDto update(ApplySectionDto dto) {
        ApplySection existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setLeftImage(dto.getLeftImage());
        existing.setRightImage(dto.getRightImage());
        return toDto(repository.save(existing));
    }

    public ApplySectionDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ApplySectionDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ApplySectionDto toDto(ApplySection e) {
        return new ApplySectionDto(
                e.getId(),
                e.getTitle(),
                e.getDescription(),
                e.getLeftImage(),
                e.getRightImage()
        );
    }
}


