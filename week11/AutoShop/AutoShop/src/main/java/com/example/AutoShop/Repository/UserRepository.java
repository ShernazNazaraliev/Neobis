package com.example.AutoShop.Repository;

import com.example.AutoShop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName (String userName);
}
