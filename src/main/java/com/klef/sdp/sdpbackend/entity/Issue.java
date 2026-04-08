package com.klef.sdp.sdpbackend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name="Issue_table")
public class Issue {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String pollingStation;

	@Column(nullable=false)
	private String issueType;

	@Column(nullable=false)
	private String description;

	@Column(nullable=false)
	private String status;

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

	public String getPollingStation() {
		return pollingStation;
	}

	public void setPollingStation(String pollingStation) {
		this.pollingStation = pollingStation;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", pollingStation=" + pollingStation + ", issueType=" + issueType + ", description="
				+ description + ", status=" + status + ", citizen=" + citizen + ", addedAt=" + addedAt + "]";
	}

	
}