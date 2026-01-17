package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.News;
import com.example.zanmetroDb.Repository.NewsRepository;
import com.example.zanmetroDb.dto.NewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository repository;

    // CREATE
    public NewsDto save(NewsDto dto) {
        News e = new News();
        e.setTitle(dto.getTitle());
        e.setDate(dto.getDate());
        e.setImage(dto.getImage());
        e.setDescription(dto.getDescription());
        return toDto(repository.save(e));
    }

    // UPDATE
    public NewsDto update(NewsDto dto) {
        News existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setTitle(dto.getTitle());
        existing.setDate(dto.getDate());
        existing.setImage(dto.getImage());
        existing.setDescription(dto.getDescription());
        return toDto(repository.save(existing));
    }

    // GET BY ID
    public NewsDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    // ✅ GET ALL (THIS WAS MISSING)
    public List<NewsDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Entity → DTO
    private NewsDto toDto(News e) {
        return new NewsDto(
                e.getId(),
                e.getTitle(),
                e.getDate(),
                e.getImage(),
                e.getDescription()
        );
    }
}
