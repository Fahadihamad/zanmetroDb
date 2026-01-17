package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Programs;
import com.example.zanmetroDb.Repository.ProgramsRepository;
import com.example.zanmetroDb.dto.ProgramsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramsService {

    private final ProgramsRepository repository;

    public ProgramsDto save(ProgramsDto dto) {
        Programs e = new Programs();
        e.setIcon(dto.getIcon());
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setImage(dto.getImage());
        return toDto(repository.save(e));
    }

    public ProgramsDto update(ProgramsDto dto) {
        Programs existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setIcon(dto.getIcon());
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setImage(dto.getImage());
        return toDto(repository.save(existing));
    }

    public ProgramsDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ProgramsDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ProgramsDto toDto(Programs e) {
        return new ProgramsDto(
                e.getId(),
                e.getIcon(),
                e.getName(),
                e.getDescription(),
                e.getImage()
        );
    }
}
