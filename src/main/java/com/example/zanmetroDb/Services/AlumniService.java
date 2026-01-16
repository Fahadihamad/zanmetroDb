package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Alumni;
import com.example.zanmetroDb.Repository.AlumniRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumniService {
    private final AlumniRepository repository;

    public Alumni save(Alumni e){ return repository.save(e); }

    public Alumni update(Alumni e){
        Alumni existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setFileName(e.getFileName());
        existing.setFile(e.getFile());
        return repository.save(existing);
    }

    public Alumni findById(Long id){ return repository.findById(id).orElse(null); }

    public List<Alumni> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

