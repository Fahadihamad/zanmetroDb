package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Message;
import com.example.zanmetroDb.Repository.MessageRepository;
import com.example.zanmetroDb.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    // CREATE
    public MessageDto save(MessageDto dto) {
        Message entity = new Message();
        entity.setMessage(dto.getMessage());
        entity.setVideo(dto.getVideo());

        return toDto(repository.save(entity));
    }

    // UPDATE (fetch + set + save)
    public MessageDto update(MessageDto dto) {
        Message existing = repository.findById(dto.getId()).orElse(null);
        if (existing == null) return null;

        existing.setMessage(dto.getMessage());
        existing.setVideo(dto.getVideo());

        return toDto(repository.save(existing));
    }

    // GET BY ID
    public MessageDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    // GET ALL
    public List<MessageDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Entity → DTO
    private MessageDto toDto(Message entity) {
        return new MessageDto(
                entity.getId(),
                entity.getMessage(),
                entity.getVideo()
        );
    }
}
