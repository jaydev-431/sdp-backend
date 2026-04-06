package com.klef.sdp.sdpbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Issue_table")
public class Issue {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	@Column(nullable=false)
	private String pollingStation;
	

	@Column(nullable=false)
	private String issueType;
	

	@Column(nullable=false)
	private String report;
	
	@ManyToOne
	@JoinColumn(name="citizen_id")
	private Citizen citizen;
	
	
	
	
	
	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
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
		issueType = issueType;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	
	@Override
	public String toString() {
		return "Issue [id=" + id + ", pollingStation=" + pollingStation + ", IssueType=" + issueType + ", report="
				+ report + ", citizen=" + citizen + "]";
	}

}
