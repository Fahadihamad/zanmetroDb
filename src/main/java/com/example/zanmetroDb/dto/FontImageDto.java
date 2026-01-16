package com.example.zanmetroDb.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FontImageDto {
    private Long id;

    private byte[] image;

    private String title;
    private String subtitle;

    private String description;
}
