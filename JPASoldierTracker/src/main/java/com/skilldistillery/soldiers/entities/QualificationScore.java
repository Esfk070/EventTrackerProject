package com.skilldistillery.soldiers.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualification_score") 
public class QualificationScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Integer score;
	
	private Boolean enabled;
	
	@UpdateTimestamp
	@Column(name = "date_taken")
	private LocalDateTime dateTaken;
	
	private Boolean passed;
	
	@ManyToOne
	private Soldier soldier;
	
	@ManyToOne
	private Nomenclature nomenclature;
//	----------Constructors----------------------------------------------------------------------------

	public QualificationScore() {
		super();
	}
//	----------Getters and Setters----------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public Nomenclature getNomenclature() {
		return nomenclature;
	}

	public void setNomenclature(Nomenclature nomenclature) {
		this.nomenclature = nomenclature;
	}

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}

	public Boolean getPassed() {
		return passed;
	}

	public void setPassed(Boolean passed) {
		this.passed = passed;
	}
//	----------HashCode Equals ToString----------------------------------------------------------------------------

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
		QualificationScore other = (QualificationScore) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "QualificationScore [id=" + id + ", score=" + score + ", enabled=" + enabled + ", dateTaken=" + dateTaken
				+ ", passed=" + passed + "]";
	}

	
	
	
	
	
	
	


}
