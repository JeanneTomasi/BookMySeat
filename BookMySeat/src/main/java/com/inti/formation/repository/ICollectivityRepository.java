package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.Collectivity;

@Repository
public interface ICollectivityRepository extends JpaRepository<Collectivity, Integer> {

}
