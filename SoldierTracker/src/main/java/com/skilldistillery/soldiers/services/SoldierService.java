package com.skilldistillery.soldiers.services;

import java.util.List;

import com.skilldistillery.soldiers.entities.Soldier;

public interface SoldierService {
	
	List<Soldier> getAllSoldiers();
	Soldier showSoldier(int soldierId);
	Soldier create(Soldier soldier);
	Soldier update(int soldierId, Soldier updatingSoldier);
	boolean delete(int soldierId);
	Soldier unenable(int soldierId);

}
