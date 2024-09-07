package com.skilldistillery.soldiers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.soldiers.entities.Soldier;
import com.skilldistillery.soldiers.repositories.SoldierRepository;

@Service
public class SoldierServiceImpl implements SoldierService {

	@Autowired 
	SoldierRepository soldierRepo;
	
	@Override
	public List<Soldier> getAllSoldiers() {
		
		return soldierRepo.findByEnabledTrue();

	}

	@Override
	public Soldier showSoldier(int soldierId) {
		Optional<Soldier> soldierOpt = soldierRepo.findById(soldierId);
		if (soldierOpt != null) {
			Soldier soldier = soldierOpt.get();
			return soldier;
		}
		return null;
	}

	@Override
	public Soldier create(Soldier soldier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Soldier update(int soldierId, Soldier updatingSoldier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int soldierId) {
		// TODO Auto-generated method stub
		return false;
	}

}
