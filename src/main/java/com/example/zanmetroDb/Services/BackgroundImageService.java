package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.BackgroundImage;
import com.example.zanmetroDb.Repository.BackgroundImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BackgroundImageService {
    private final BackgroundImageRepository repository;

    public BackgroundImage save(BackgroundImage e){ return repository.save(e); }

    public BackgroundImage update(BackgroundImage e){
        BackgroundImage existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setBackground1(e.getBackground1());
        existing.setBackground2(e.getBackground2());
        return repository.save(existing);
    }

    public BackgroundImage findById(Long id){ return repository.findById(id).orElse(null); }

    public List<BackgroundImage> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

