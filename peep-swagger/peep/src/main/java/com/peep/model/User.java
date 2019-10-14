package com.peep.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique = true, length = 128)
	private String name;
	@Column(nullable = false, unique = true, length = 128)
	private String email;
	@Column(nullable = false)
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
//	@JsonIgnore
	@JsonIgnoreProperties(value = { "user" })
	private UserProfile userProfile;

//	@OneToMany(targetEntity = Following.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
//	private Set<Following> followers;
//
//	@OneToMany(targetEntity = Following.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "followee")
//	private Set<Following> followings;

	@OneToMany(targetEntity = Peep.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnoreProperties(value = { "user" })
	private Set<Peep> peeps;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	// DISABLE GETTERS TO FORCE NOT RETURNING INNER OBJECTS (FORCE FETCH LAZY)
//	public Set<Following> getFollowers() {
//		return followers;
//	}

//	public void setFollowers(Set<Following> followers) {
//		this.followers = followers;
//	}
//
////	public Set<Following> getFollowings() {
////		return followings;
////	}
//
//	public void setFollowings(Set<Following> followings) {
//		this.followings = followings;
//	}

	// DISABLE GETTERS TO FORCE NOT RETURNING INNER OBJECTS (FORCE FETCH LAZY)
//	public Set<Peep> getPeeps() {
//		return peeps;
//	}

	public void setPeeps(Set<Peep> peeps) {
		this.peeps = peeps;
	}

}
