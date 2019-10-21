package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

}
