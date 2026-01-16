package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.ApplySection;
import com.example.zanmetroDb.Repository.ApplySectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplySectionService {
    private final ApplySectionRepository repository;

    public ApplySection save(ApplySection e){ return repository.save(e); }

    public ApplySection update(ApplySection e){
        ApplySection existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setTitle(e.getTitle());
        existing.setDescription(e.getDescription());
        existing.setLeftImage(e.getLeftImage());
        existing.setRightImage(e.getRightImage());
        return repository.save(existing);
    }

    public ApplySection findById(Long id){ return repository.findById(id).orElse(null); }

    public List<ApplySection> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

