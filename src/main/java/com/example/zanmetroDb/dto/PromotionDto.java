package com.example.zanmetroDb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDto {

    private Long id;
    private byte[] icon;
    private byte[] image;
    private String title;
    private String description;
}


