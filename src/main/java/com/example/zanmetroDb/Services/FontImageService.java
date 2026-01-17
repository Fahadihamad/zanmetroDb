package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.FontImage;
import com.example.zanmetroDb.Repository.FontImageRepository;
import com.example.zanmetroDb.dto.FontImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FontImageService {

    private final FontImageRepository repository;

    public FontImageDto save(FontImageDto dto) {
        FontImage e = new FontImage();
        e.setImage(dto.getImage());
        e.setTitle(dto.getTitle());
        e.setSubtitle(dto.getSubtitle());
        e.setDescription(dto.getDescription());
        return toDto(repository.save(e));
    }

    public FontImageDto update(FontImageDto dto) {
        FontImage existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setImage(dto.getImage());
        existing.setTitle(dto.getTitle());
        existing.setSubtitle(dto.getSubtitle());
        existing.setDescription(dto.getDescription());
        return toDto(repository.save(existing));
    }

    public FontImageDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<FontImageDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private FontImageDto toDto(FontImage e) {
        return new FontImageDto(
                e.getId(),
                e.getImage(),
                e.getTitle(),
                e.getSubtitle(),
                e.getDescription()
        );
    }
}
