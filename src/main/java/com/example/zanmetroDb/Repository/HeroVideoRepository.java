package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.HeroVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroVideoRepository extends JpaRepository<HeroVideo, Long> {}

