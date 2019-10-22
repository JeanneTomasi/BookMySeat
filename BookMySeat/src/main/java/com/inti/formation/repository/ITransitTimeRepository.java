package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.TransitTime;

@Repository
public interface ITransitTimeRepository extends JpaRepository<TransitTime, Integer> {

}
