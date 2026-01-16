package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.ApplySection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplySectionRepository extends JpaRepository<ApplySection, Long> {}

