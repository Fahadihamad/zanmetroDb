package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    List<Staff> findByUser_UserId(String userId);

}
