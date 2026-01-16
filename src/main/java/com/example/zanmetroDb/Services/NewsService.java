package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.News;
import com.example.zanmetroDb.Repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository repository;

    public News save(News e){ return repository.save(e); }

    public News update(News e){
        News existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setTitle(e.getTitle());
        existing.setDate(e.getDate());
        existing.setImage(e.getImage());
        existing.setDescription(e.getDescription());
        return repository.save(existing);
    }

    public News findById(Long id){ return repository.findById(id).orElse(null); }

    public List<News> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

