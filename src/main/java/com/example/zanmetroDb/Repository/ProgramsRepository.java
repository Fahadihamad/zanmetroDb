package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramsRepository extends JpaRepository<Programs, Long> {}

