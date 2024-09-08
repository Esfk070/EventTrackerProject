package com.skilldistillery.soldiers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.soldiers.entities.Soldier;
import com.skilldistillery.soldiers.services.SoldierService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class SoldierController {
	
	@Autowired
	private SoldierService soldierService;
	
	@GetMapping("soldiers")
	public List<Soldier> getSoldierList(){
		
		return soldierService.getAllSoldiers();
	}
	
	@GetMapping("soldier/{id}")
	public Soldier getSoldierById(@PathVariable("id") Integer id, HttpServletResponse res) {
		Soldier soldier = soldierService.showSoldier(id);
		if (soldier.getEnabled()==false || soldier == null)
		{
			soldier = null;
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		
		return soldier;
	}
	
	@PostMapping("soldier")
	public Soldier createSoldier(@RequestBody Soldier soldier, HttpServletResponse response, HttpServletRequest request) {
		
		Soldier createdSoldier = null;	
		try {
			createdSoldier = soldierService.create(soldier);
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.setHeader("Location", request.getRequestURL()+ "/" 
			+ createdSoldier.getId());
		} catch (Exception e) {
			
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return createdSoldier;
	}

	
	@PutMapping("soldier/{soldierId}")
	public Soldier updateSoldier(@PathVariable("soldierId") int soldierId,
								 @RequestBody Soldier soldier,
								 HttpServletResponse response) {
		Soldier updatedSoldier = null;
		
		updatedSoldier = soldierService.update(soldierId, soldier);
		System.out.println();
		System.out.println();
		System.out.println(soldierService);
		System.out.println();
		return updatedSoldier;
	}
	
	@DeleteMapping("soldier/{soldierId}")
	public void deleteSoldier(
			 			@PathVariable("soldierId") int soldierId,
			 			HttpServletResponse response
			 			){
		Soldier soldier = soldierService.showSoldier(soldierId);
		
		if (soldier == null){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		else {
			try {
				soldierService.delete(soldierId);
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(400);
			}
		}
		
	}
	
	
	
	
	
	
	
}
