package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.SeatReservation;
@Repository
public interface ISeatReservationRepository extends JpaRepository<SeatReservation, Integer>{

}
