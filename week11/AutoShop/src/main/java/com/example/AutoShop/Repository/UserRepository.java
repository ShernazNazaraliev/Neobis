package com.example.AutoShop.Repository;

import com.example.AutoShop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName (String userName);
}
