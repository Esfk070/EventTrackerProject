package com.skilldistillery.soldiers.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weapon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="serial_number")
	private Integer serialNumber;
	
	private Boolean fmc;
//	----------Constructors----------------------------------------------------------------------------

	public Weapon() {
		super();
	}
//	----------getters setters----------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Boolean getFmc() {
		return fmc;
	}

	public void setFmc(Boolean fmc) {
		this.fmc = fmc;
	}
//	----------hacshCodeEquals to string----------------------------------------------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weapon other = (Weapon) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "weapon [id=" + id + ", serialNumber=" + serialNumber + ", fmc=" + fmc + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
}
