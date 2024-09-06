package com.skilldistillery.soldiers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.soldiers.entities.Soldier;
import com.skilldistillery.soldiers.services.SoldierService;

@RestController
@RequestMapping("api")
public class SoldierController {
	
	@Autowired
	private SoldierService soldierService;
	
	@GetMapping("soldiers")
	public List<Soldier> getSoldierList(){
		
		return soldierService.getAllSoldiers();
	}
	

}
