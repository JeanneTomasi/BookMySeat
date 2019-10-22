package com.inti.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entity.TablePorteuseId;
import com.inti.formation.entity.TablePorteuseStation_Line_Vehicle;

@Repository
public interface ITablePorteuseRepository extends JpaRepository<TablePorteuseStation_Line_Vehicle, TablePorteuseId> {

}
