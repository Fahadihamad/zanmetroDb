package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.FontImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FontImageRepository extends JpaRepository<FontImage,Long> {
}
