package com.example.zanmetroDb.Repository;

import com.example.zanmetroDb.Model.Roles;
import com.example.zanmetroDb.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByActivationToken(String token);

    long countByRoles(Roles roles);

    List<User> findByRoles_RoleName(String roleName);
}

