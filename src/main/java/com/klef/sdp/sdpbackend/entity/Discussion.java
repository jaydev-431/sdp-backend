package com.klef.sdp.sdpbackend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="discussions_table")
public class Discussion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String comment;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="citizen_id")
	private Citizen citizen;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDateTime addedAt;
	
	
	
	public LocalDateTime getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(LocalDateTime addedAt) {
		this.addedAt = addedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", comment=" + comment + ", citizen=" + citizen + ", addedAt=" + addedAt + "]";
	}

	
	
	
	
	
	
}
