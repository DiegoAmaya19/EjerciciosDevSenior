package com.example.userLogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.userLogin.Model.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
     
    Boolean existsByUsernameAndPassword(String username, String password);
}
