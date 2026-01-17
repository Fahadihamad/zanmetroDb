package com.example.zanmetroDb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {

    private Long id;
    private String title;
    private LocalDate date;
    private byte[] image;        // ✅ byte[]
    private String description;  // ✅ String
}


