package com.aplication.twitter.repository;

import com.aplication.twitter.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository <User,Integer> {
        Optional<User> findByUserName(String userName);
        boolean existsByUserName(String userName);
        boolean existsByEmail(String email);
        public List<User> findByBirthOfDate(Date birthOfDate);

}