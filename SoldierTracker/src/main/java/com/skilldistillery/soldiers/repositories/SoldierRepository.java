package com.skilldistillery.soldiers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.soldiers.entities.Soldier;

public interface SoldierRepository extends JpaRepository<Soldier, Integer> {

}
