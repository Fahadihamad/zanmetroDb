package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Contacts;
import com.example.zanmetroDb.Repository.ContactsRepository;
import com.example.zanmetroDb.dto.ContactsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsService {

    private final ContactsRepository repository;

    public ContactsDto save(ContactsDto dto) {
        Contacts e = new Contacts();
        e.setLocation(dto.getLocation());
        e.setEmail(dto.getEmail());
        e.setPhone(dto.getPhone());
        e.setWorkDays(dto.getWorkDays());
        return toDto(repository.save(e));
    }

    public ContactsDto update(ContactsDto dto) {
        Contacts existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setLocation(dto.getLocation());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setWorkDays(dto.getWorkDays());
        return toDto(repository.save(existing));
    }

    public ContactsDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<ContactsDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ContactsDto toDto(Contacts e) {
        return new ContactsDto(
                e.getId(),
                e.getLocation(),
                e.getEmail(),
                e.getPhone(),
                e.getWorkDays()
        );
    }
}


