package com.klef.sdp.sdpbackend.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="citizen_table")
public class Citizen {
	
	@JsonManagedReference
	@OneToMany(mappedBy="citizen")
	private List<Issue> issues;
	
	@JsonManagedReference
	@OneToMany(mappedBy="citizen")
	private List<Discussion> discussions;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)
    private Long id;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false, unique = true)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private int age;

    @Column( nullable = false)
    private String gender;

    @Column( nullable = false, unique = true)
    private String contact;

    @Column( nullable = false)
    private String location;

    @CreationTimestamp
    @Column(  updatable = false)
    private LocalDateTime registeredAt;
	
	
    @Override
	public String toString() {
		return "Citizen [reports=" + issues + ", discussions=" + discussions + ", id=" + id + ", name=" + name
				+ ", email=" + email + ", password=" + password + ", age=" + age + ", gender=" + gender + ", contact="
				+ contact + ", location=" + location + ", registeredAt=" + registeredAt + "]";
	}

	public List<Issue> getReports() {
		return issues;
	}

	public void setReports(List<Issue> reports) {
		this.issues = reports;
	}

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

	
}