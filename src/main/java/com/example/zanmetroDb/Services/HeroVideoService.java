package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.HeroVideo;
import com.example.zanmetroDb.Repository.HeroVideoRepository;
import com.example.zanmetroDb.dto.HeroVideoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroVideoService {

    private final HeroVideoRepository repository;

    public HeroVideoDto save(HeroVideoDto dto) {
        HeroVideo e = new HeroVideo();
        e.setVideo(dto.getVideo());
        return toDto(repository.save(e));
    }

    public HeroVideoDto update(HeroVideoDto dto) {
        HeroVideo existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setVideo(dto.getVideo());
        return toDto(repository.save(existing));
    }

    public HeroVideoDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<HeroVideoDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private HeroVideoDto toDto(HeroVideo e) {
        return new HeroVideoDto(e.getId(), e.getVideo());
    }
}

