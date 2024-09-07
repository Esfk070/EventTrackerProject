package com.skilldistillery.soldiers.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nomenclature") 
public class Nomenclature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private Boolean enabled;
	
	@OneToMany(mappedBy = "nomenclature")
	private List<Weapon> weapons;
	
	@OneToMany(mappedBy = "nomenclature")
	private List<QualificationScore> qualificationScores;
	
//	----------Constructors----------------------------------------------------------------------------
	
	public Nomenclature() {
		super();
	}

//	----------Getters and Setters----------------------------------------------------------------------------
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

	public List<QualificationScore> getQualificationScores() {
		return qualificationScores;
	}

	public void setQualificationScores(List<QualificationScore> qualificationScores) {
		this.qualificationScores = qualificationScores;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
//	----------HashCodeEquals ToString----------------------------------------------------------------------------

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
		Nomenclature other = (Nomenclature) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "QualifcationScoreWeapon [id=" + id + ", name=" + name + ", enabled=" + enabled + "]";
	}
	
	

}
