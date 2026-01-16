package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Long> {

}


