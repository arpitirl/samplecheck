package com.training.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="Plan")
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int plan;
	public Plan(int plan) {
		super();
		this.plan = plan;
	}
	
	public Plan() {
		super();
	}

	@OneToMany(mappedBy = "plan")
	private List<Register> users;

}
