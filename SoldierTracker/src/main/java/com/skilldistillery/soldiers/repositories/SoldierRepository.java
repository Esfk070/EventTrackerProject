package com.skilldistillery.soldiers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.soldiers.entities.Soldier;

public interface SoldierRepository extends JpaRepository<Soldier, Integer> {
	List<Soldier> findByEnabledTrue();
}
