package com.skilldistillery.soldiers.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualificationscore_weapon") 
public class QualificationScoreWeapon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private Boolean enabled;
//	----------Constructors----------------------------------------------------------------------------
	
	public QualificationScoreWeapon() {
		super();
	}

//	----------Getters and Setters----------------------------------------------------------------------------
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		QualificationScoreWeapon other = (QualificationScoreWeapon) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "QualifcationScoreWeapon [id=" + id + ", name=" + name + ", enabled=" + enabled + "]";
	}
	
	

}
