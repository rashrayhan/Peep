package com.peep.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userId", "followeeId" }))
public class Following {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;

//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user; // the follower, the one who did the follow action

//	@ManyToOne
//	@JoinColumn(name = "followee_id")
//	private User followee;

	private long userId;
	private long followeeId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFolloweeId() {
		return followeeId;
	}

	public void setFolloweeId(long followeeId) {
		this.followeeId = followeeId;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public User getFollowee() {
//		return followee;
//	}
//
//	public void setFollowee(User followee) {
//		this.followee = followee;
//	}

}
