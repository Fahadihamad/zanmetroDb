package com.example.zanmetroDb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CounterDto {
    private Long id;
    private Integer numberOfYears;
    private Integer graduates;
    private Integer partners;
}

