package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Counter;
import com.example.zanmetroDb.Repository.CounterRepository;
import com.example.zanmetroDb.dto.CounterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final CounterRepository repository;

    public CounterDto save(CounterDto dto) {
        Counter e = new Counter();
        e.setNumberOfYears(dto.getNumberOfYears());
        e.setGraduates(dto.getGraduates());
        e.setPartners(dto.getPartners());
        return toDto(repository.save(e));
    }

    public CounterDto update(CounterDto dto) {
        Counter existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setNumberOfYears(dto.getNumberOfYears());
        existing.setGraduates(dto.getGraduates());
        existing.setPartners(dto.getPartners());
        return toDto(repository.save(existing));
    }

    public CounterDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<CounterDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CounterDto toDto(Counter e) {
        return new CounterDto(e.getId(), e.getNumberOfYears(), e.getGraduates(), e.getPartners());
    }
}


