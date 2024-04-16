package com.booking.stayease.Repository;

import org.springframework.stereotype.Repository;

import com.booking.stayease.Entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByEmail(String email);
}
