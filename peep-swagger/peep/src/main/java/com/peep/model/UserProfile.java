package com.peep.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fullName;
	private LocalDate birth_date;
	private String mobile;
	private String bio;
	private String profile_photo;
	private String cover_photo;

//	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getCover_photo() {
		return cover_photo;
	}

	public void setCover_photo(String cover_photo) {
		this.cover_photo = cover_photo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
