package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.Station;

@Repository
public interface IStationRepository extends JpaRepository<Station, Integer>{

}
