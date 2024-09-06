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

class SoldierTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Soldier soldier;

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
		soldier = em.find(Soldier.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		soldier = null;
	}

	@Test
	void test() {
		assertNotNull(soldier);
		assertEquals("Frank", soldier.getFirstName());
	}

}
