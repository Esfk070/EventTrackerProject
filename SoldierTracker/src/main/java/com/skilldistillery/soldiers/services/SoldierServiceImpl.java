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
		System.out.println();
		System.out.println(soldierOpt);
		System.out.println();
 		if (soldierOpt.isPresent()) {
			Soldier soldier = soldierOpt.get();
			return soldier;
		}
		return null;
	}

	@Override
	public Soldier create(Soldier soldier) {
		soldier.setEnabled(true);
		System.out.println(soldier);
		soldierRepo.saveAndFlush(soldier);
		return soldier;
	}

	@Override
	public Soldier update(int soldierId, Soldier updatingSoldier) {
		Optional<Soldier> oldSoldierOpt= soldierRepo.findById(soldierId);
		Soldier managedSoldier = null;
		if(oldSoldierOpt.isPresent()) {
			managedSoldier = oldSoldierOpt.get();
			
			managedSoldier.setAcfts(updatingSoldier.getAcfts());
			managedSoldier.setCreateDate(updatingSoldier.getCreateDate());
			managedSoldier.setDescription(updatingSoldier.getDescription());
			managedSoldier.setDod(updatingSoldier.getDod());
			managedSoldier.setEnabled(updatingSoldier.getEnabled());
			managedSoldier.setFirstName(updatingSoldier.getFirstName());
			managedSoldier.setImageUrl(updatingSoldier.getImageUrl());
			managedSoldier.setLastName(updatingSoldier.getLastName());
			managedSoldier.setLastUpdate(updatingSoldier.getLastUpdate());
			managedSoldier.setProfile(updatingSoldier.getProfile());
			managedSoldier.setQualificationScores(updatingSoldier.getQualificationScores());
			managedSoldier.setWeapons(updatingSoldier.getWeapons());
			
			soldierRepo.saveAndFlush(managedSoldier);
		}
		
		return managedSoldier;
	}

	@Override
	public boolean delete(int soldierId) {
		boolean deleted = false;
		Soldier deletedSoldier = soldierRepo.getById(soldierId);
		soldierRepo.deleteById(soldierId);
		if (deletedSoldier == null) {
			deleted = true;
		}
		
		return deleted;
	}

	@Override
	public Soldier unenable(int soldierId) {
		Soldier soldier = null;
		Optional<Soldier> soldierOpt = soldierRepo.findById(soldierId);
		if (soldierOpt.isPresent()) {
			soldier = soldierOpt.get();
			soldier.setEnabled(false);
			soldierRepo.saveAndFlush(soldier);
			}
		
		
		return soldier;
	}

}
