package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.BackgroundImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundImageRepository extends JpaRepository<BackgroundImage, Long> {}

