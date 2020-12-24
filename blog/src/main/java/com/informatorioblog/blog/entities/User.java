package com.informatorioblog.blog.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userID;
	@Column(nullable = false)
	@NotEmpty
	@NotBlank
	private String name;
	@Column(nullable = false)
	@NotEmpty
	@NotBlank
	private String lastName;
	@Column(unique = true, nullable = false)
	@NotEmpty
	@Email
	@NotBlank
	private String email; 
	@Column(nullable = false)
	@NotEmpty
	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password; 
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp userRegistrationDate;
	@Column(nullable = false)
	@NotEmpty
	@NotBlank
	private String city;
	@Column(nullable = false)
	@NotEmpty
	@NotBlank
	private String province;
	@Column(nullable = false)
	@NotEmpty
	@NotBlank
	private String country;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Post> posts;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> comments;

	@PrePersist
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setRegistrationDate(){
		this.userRegistrationDate = new Timestamp(new Date().getTime());
	}

	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getUserRegistrationDate() {	
		return userRegistrationDate;
	}
	public void setUserRegistrationDate(Timestamp userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

    public void updateUser(User user) {
		if(user.getName() != null && !(user.getName().equals(this.name))){
			this.name = user.getName();
		}
		if(user.getLastName() != null && !(user.getLastName().equals(this.lastName))){
			this.lastName = user.getLastName();
		}
		if(user.getCity() != null && !(user.getCity().equals(this.city))){
			this.city = user.getCity();
		}
		if(user.getProvince() != null && !(user.getProvince().equals(this.province))){
			this.province = user.getProvince();
		}
		if(user.getCountry() != null && !(user.getCountry().equals(this.country))){
			this.country = user.getCountry();
		}
		if(user.getEmail() != null && !(user.getEmail().equals(this.email))){
			this.email = user.getEmail();
		}
		
	}
}
