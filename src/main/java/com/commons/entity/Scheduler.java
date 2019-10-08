package com.commons.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "scheduler")
public class Scheduler {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Date endTime;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@Column(name = "event_name")
	private String eventName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "schedules_user", 
			joinColumns = {@JoinColumn(name = "schedules_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = {@JoinColumn(name = "user_id",nullable = false, updatable = false) })
	public Set<User> user;

	@ManyToOne
	@JoinColumn(name = "meeting_room_details_id")
	private MeetingRoomDetails meetingRoomDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public MeetingRoomDetails getMeetingRoomDetails() {
		return meetingRoomDetails;
	}

	public void setMeetingRoomDetails(MeetingRoomDetails meetingRoomDetails) {
		this.meetingRoomDetails = meetingRoomDetails;
	}
	
	
	
}
