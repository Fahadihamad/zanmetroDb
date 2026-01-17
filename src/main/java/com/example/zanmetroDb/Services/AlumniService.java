package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Alumni;
import com.example.zanmetroDb.Repository.AlumniRepository;
import com.example.zanmetroDb.dto.AlumniDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumniService {

    private final AlumniRepository repository;

    public AlumniDto save(AlumniDto dto) {
        Alumni e = new Alumni();
        e.setFileName(dto.getFileName());
        e.setFile(dto.getFile());
        return toDto(repository.save(e));
    }

    public AlumniDto update(AlumniDto dto) {
        Alumni existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setFileName(dto.getFileName());
        existing.setFile(dto.getFile());
        return toDto(repository.save(existing));
    }

    public AlumniDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<AlumniDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AlumniDto toDto(Alumni e) {
        return new AlumniDto(e.getId(), e.getFileName(), e.getFile());
    }
}


