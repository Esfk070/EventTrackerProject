package com.skilldistillery.soldiers.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class NomenclatureTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Nomenclature qualificationScoreWeapon;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPASoldierTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		qualificationScoreWeapon = em.find(Nomenclature.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		qualificationScoreWeapon = null;
	}

	@Test
	void test() {
		assertNotNull(qualificationScoreWeapon);
		assertEquals("M4", qualificationScoreWeapon.getName());
	}
	@Test
	void test_nomenclature_has_many_weapons() {
		assertNotNull(qualificationScoreWeapon);
		assertTrue( qualificationScoreWeapon.getWeapons().size()>0);
	}
	@Test
	void test_nomenclature_has_many_QualificationScores() {
		assertNotNull(qualificationScoreWeapon);
		assertTrue( qualificationScoreWeapon.getQualificationScores().size()>0);
	}

}
