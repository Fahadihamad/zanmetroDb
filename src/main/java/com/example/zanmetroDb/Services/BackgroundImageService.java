package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.BackgroundImage;
import com.example.zanmetroDb.Repository.BackgroundImageRepository;
import com.example.zanmetroDb.dto.BackgroundImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BackgroundImageService {

    private final BackgroundImageRepository repository;

    public BackgroundImageDto save(BackgroundImageDto dto) {
        BackgroundImage e = new BackgroundImage();
        e.setBackground1(dto.getBackground1());
        e.setBackground2(dto.getBackground2());
        return toDto(repository.save(e));
    }

    public BackgroundImageDto update(BackgroundImageDto dto) {
        BackgroundImage existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setBackground1(dto.getBackground1());
        existing.setBackground2(dto.getBackground2());
        return toDto(repository.save(existing));
    }

    public BackgroundImageDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<BackgroundImageDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BackgroundImageDto toDto(BackgroundImage e) {
        return new BackgroundImageDto(
                e.getId(),
                e.getBackground1(),
                e.getBackground2()
        );
    }
}
