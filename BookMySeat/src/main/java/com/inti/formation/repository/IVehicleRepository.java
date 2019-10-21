package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer>{

}
