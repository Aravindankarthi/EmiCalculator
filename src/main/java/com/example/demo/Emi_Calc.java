package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emi_Calc {
	private String name;
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private double Loan_amt,Tenure;
	private double Int_rate;
	public double getLoan_amt() {
		return Loan_amt;
	}
	public void setLoan_amt(double loan_amt) {
		Loan_amt = loan_amt;
	}
	public double getTenure() {
		return Tenure;
	}
	public void setTenure(double tenure) {
		Tenure = tenure;
	}
	public double getInt_rate() {
		return Int_rate;
	}
	public void setInt_rate(double int_rate) {
		Int_rate = int_rate;
	}
	
}
