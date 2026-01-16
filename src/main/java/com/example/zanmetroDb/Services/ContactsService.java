package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Contacts;
import com.example.zanmetroDb.Repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsService {
    private final ContactsRepository repository;

    public Contacts save(Contacts e){ return repository.save(e); }

    public Contacts update(Contacts e){
        Contacts existing = repository.findById(e.getId()).orElse(null);
        if(existing == null) return null;
        existing.setLocation(e.getLocation());
        existing.setEmail(e.getEmail());
        existing.setPhone(e.getPhone());
        existing.setWorkDays(e.getWorkDays());
        return repository.save(existing);
    }

    public Contacts findById(Long id){ return repository.findById(id).orElse(null); }

    public List<Contacts> findAll(){ return repository.findAll(); }

    public void delete(Long id){ repository.deleteById(id); }
}

