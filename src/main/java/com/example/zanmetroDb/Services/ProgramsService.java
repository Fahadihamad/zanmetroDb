package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Programs;
import com.example.zanmetroDb.Repository.ProgramsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramsService {
    private final ProgramsRepository repository;

    public Programs save(Programs e){ return repository.save(e); }

    public Programs update(Programs e){
        Programs existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setIcon(e.getIcon());
        existing.setName(e.getName());
        existing.setDescription(e.getDescription());
        existing.setImage(e.getImage());
        return repository.save(existing);
    }

    public Programs findById(Long id){ return repository.findById(id).orElse(null); }

    public List<Programs> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

