package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Users;

public interface Usersrepository extends JpaRepository<Users,Integer>{

public Users findByEmail(String email);
}
