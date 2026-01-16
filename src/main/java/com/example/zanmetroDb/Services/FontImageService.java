package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.FontImage;
import com.example.zanmetroDb.Repository.FontImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FontImageService {
    private final FontImageRepository repository;

    public FontImage save(FontImage e){ return repository.save(e); }

    public FontImage update(FontImage e){
        FontImage existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setImage(e.getImage());
        existing.setTitle(e.getTitle());
        existing.setSubtitle(e.getSubtitle());
        existing.setDescription(e.getDescription());
        return repository.save(existing);
    }

    public FontImage findById(Long id){ return repository.findById(id).orElse(null); }

    public List<FontImage> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

