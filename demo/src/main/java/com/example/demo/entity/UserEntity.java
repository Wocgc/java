package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Entity
@Setter
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(nullable=false)
	private Long id;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Builder
	public UserEntity(String email, String password, String role) {
		this.email=email;
		this.password=password;
		this.role=role;
	}
}
