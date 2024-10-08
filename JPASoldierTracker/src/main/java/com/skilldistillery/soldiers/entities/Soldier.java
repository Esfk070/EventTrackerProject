package com.skilldistillery.soldiers.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Soldier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "military_rank")
	private String militaryRank;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	private Boolean enabled;
	
	private Boolean profile;
	
	private String description;
	
	private Integer dod;
	
	@JsonIgnore
	@OneToMany(mappedBy="soldier")
	private List<Acft> acfts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "soldier")
	private List<Weapon> weapons;
	
	@JsonIgnore
	@OneToMany(mappedBy = "soldier")
	private List<QualificationScore> qualificationScores;
//	----------Constructors----------------------------------------------------------------------------
	
	public Soldier() {
		super();
	}
//	----------Getters and Setters ----------------------------------------------------------------------------
	
	
	
	
	public int getId() {
		return id;
	}

	public List<Acft> getAcfts() {
		return acfts;
	}




	public void setAcfts(List<Acft> acfts) {
		this.acfts = acfts;
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




	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public List<Weapon> getWeapons() {
		return weapons;
	}




	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}




	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	
	
	public String getMilitaryRank() {
		return militaryRank;
	}

	public void setMilitaryRank(String rank) {
		this.militaryRank = rank;
	}

	public Boolean getProfile() {
		return profile;
	}

	public void setProfile(Boolean profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDod() {
		return dod;
	}

	public void setDod(Integer dod) {
		this.dod = dod;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	
	
	
//	----------hashCode Equals toString----------------------------------------------------------------------------

	
	
	
	
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
		Soldier other = (Soldier) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Soldier [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", createDate="
				+ createDate + ", lastUpdate=" + lastUpdate + ", imageUrl=" + imageUrl + ", enabled=" + enabled + "]";
	}
	
	
	
	

}
