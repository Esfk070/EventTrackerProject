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

class AcftTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Acft acft;

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
		acft = em.find(Acft.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		acft = null;
	}

	@Test
	void test_basic_mapping() {
		assertNotNull(acft);
		assertEquals(600, acft.getScore());
	}
	@Test
	void test_Acft_has_soldier() {
		assertNotNull(acft);
		acft.getSoldier().getFirstName();
		assertEquals("Alan", acft.getSoldier().getFirstName());
	}

}
