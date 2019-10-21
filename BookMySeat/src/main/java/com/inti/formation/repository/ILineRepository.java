package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.Line;

@Repository
public interface ILineRepository extends JpaRepository<Line, Integer> {

}
