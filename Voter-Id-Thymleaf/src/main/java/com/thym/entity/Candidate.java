package com.thym.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="age")
    private int age;
	
	@Column(name="city")
    private String city;

	
	//-----------------------------------------------------------------------
    //Constructor
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String name, int age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	//-----------------------------------------------------------------------
	//Getter and Setter
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
