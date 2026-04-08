package com.klef.sdp.sdpbackend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "report_table")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long observerId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String issueType;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Long getObserverId() {
    return observerId;
  }


  public void setObserverId(Long observerId) {
    this.observerId = observerId;
  }


  public String getLocation() {
    return location;
  }


  public void setLocation(String location) {
    this.location = location;
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


  public LocalDateTime getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  @Override
    public String toString() {
        return "Report [id=" + id + ", observerId=" + observerId + ", location=" + location +
                ", issueType=" + issueType + ", description=" + description +
                ", status=" + status + ", createdAt=" + createdAt + "]";
    }
    
}