package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Header;
import com.example.zanmetroDb.Repository.HeaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeaderService {
    private final HeaderRepository repository;

    public Header save(Header h){ return repository.save(h); }

    public Header update(Header h){
        Header existing = repository.findById(h.getId()).orElse(null);
        if(existing == null) return null;
        existing.setParagraph(h.getParagraph());
        return repository.save(existing);
    }

    public Header findById(Long id){ return repository.findById(id).orElse(null); }

    public List<Header> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}
