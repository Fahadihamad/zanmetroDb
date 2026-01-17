package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Long> {}

