package com.skilldistillery.soldiers.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class QualificationScoreWeaponTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private QualificationScoreWeapon qualificationScoreWeapon;
	

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
		qualificationScoreWeapon = em.find(QualificationScoreWeapon.class, 1);
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

}
