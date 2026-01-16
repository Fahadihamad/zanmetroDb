package com.example.zanmetroDb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
}

