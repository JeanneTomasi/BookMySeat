package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.Seat;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Integer>{

}
