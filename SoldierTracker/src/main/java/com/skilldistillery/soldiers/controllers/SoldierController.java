package com.skilldistillery.soldiers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.soldiers.entities.Acft;
import com.skilldistillery.soldiers.entities.Soldier;
import com.skilldistillery.soldiers.services.SoldierService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class SoldierController {

	@Autowired
	private SoldierService soldierService;

	@GetMapping("soldiers")
	public List<Soldier> getSoldierList() {

		return soldierService.getAllSoldiers();
	}

	@GetMapping("soldier/{id}")
	public Soldier getSoldierById(@PathVariable("id") Integer id, HttpServletResponse res) {
		Soldier soldier = soldierService.showSoldier(id);
		if (soldier == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return soldier;
		}
		if (soldier.getEnabled() == false || soldier == null) {
			soldier = null;
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		return soldier;
	}

	@GetMapping("soldiers/acfts")
	public double getPlatoonsAcftAverage(HttpServletResponse res) {

		List<Soldier> soldiers = soldierService.getAllSoldiers();
		double sum = 0;
		int count = 0;
		for (Soldier sold : soldiers) {
			if (sold.getAcfts().size() >=1) {
			List<Acft> soldierAcfts = sold.getAcfts();
			Acft lastAcft = soldierAcfts.get(soldierAcfts.size() - 1);
			sum = sum + lastAcft.getScore();	
			count = count + 1;
			}
			else {
				
			}

		}
		double average = sum / count;
		return average;
	}

	@PostMapping("soldier")
	public Soldier createSoldier(@RequestBody Soldier soldier, HttpServletResponse response,
			HttpServletRequest request) {

		Soldier createdSoldier = null;
		try {
			createdSoldier = soldierService.create(soldier);
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.setHeader("Location", request.getRequestURL() + "/" + createdSoldier.getId());
		} catch (Exception e) {

			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

		return createdSoldier;
	}

	@PutMapping("soldier/{soldierId}")
	public Soldier updateSoldier(@PathVariable("soldierId") int soldierId, @RequestBody Soldier soldier,
			HttpServletResponse response) {
		Soldier updatedSoldier = null;

		if (soldier.getFirstName() == null || soldier.getLastName() == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400

		} else if (soldier != null) {

			updatedSoldier = soldierService.update(soldierId, soldier);
			if (updatedSoldier == null) {

				response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		}

		return updatedSoldier;
	}

	@DeleteMapping("soldier/{soldierId}")
	public void deleteSoldier(@PathVariable("soldierId") int soldierId, HttpServletResponse response) {
		Soldier soldier = soldierService.showSoldier(soldierId);

		if (soldier == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			try {
				soldierService.delete(soldierId);
				response.setStatus(204);
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(400);
			}
		}

	}

	// un-enable Soldier
	@DeleteMapping("soldierun/{soldierId}")
	public void unenableSoldier(@PathVariable("soldierId") int soldierId, HttpServletResponse response) {
		Soldier soldier = soldierService.showSoldier(soldierId);
		if (soldier == null) {
			response.setStatus(404);

		} else {
			soldierService.unenable(soldierId);

		}
	}

}
