package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double pensionAmount;
	private double bankServiceCharge;
	
	public PensionDetail(String name, double pensionAmount, double bankServiceCharge) {
		super();
		this.name = name;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge= bankServiceCharge;
	}
	

	
	

}
