package com.peep.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Peep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String text;
	private Date date;
	private String image;
	private long userIdValue;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.setUserIdValue(user.getId());
	}

	public long getUserIdValue() {
		return userIdValue;
	}

	public void setUserIdValue(long userIdValue) {
		this.userIdValue = userIdValue;
	}

}
