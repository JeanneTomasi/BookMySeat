package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.TransportEntreprise;
@Repository
public interface ITransportEntrepriseRepository extends JpaRepository<TransportEntreprise, Integer>{

}
