package com.example.zanmetroDb.Services;

import com.example.zanmetroDb.Model.Staff;
import com.example.zanmetroDb.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Short course not found with id " + id));
    }

    public List<Staff> getStaffByUserId(String userId) {
        return staffRepository.findByUser_UserId(userId);
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff sc = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Short course not found with id " + id));

        sc.setStaffId(updatedStaff.getStaffId());
        sc.setDepartment(updatedStaff.getDepartment());
        sc.setName(updatedStaff.getName());
        sc.setGender(updatedStaff.getGender());
        sc.setPosition(updatedStaff.getPosition());
        sc.setEmploy_No(updatedStaff.getEmploy_No());
        sc.setUser(updatedStaff.getUser());

        return staffRepository.save(sc);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
