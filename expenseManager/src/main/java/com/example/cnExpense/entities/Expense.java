package com.example.cnExpense.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private double amount;
	@Column
	private LocalDate date;
	@Column
	private String description;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne(mappedBy = "expense")
	@JsonBackReference
	private Income income;
	@OneToMany(mappedBy = "expense", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JsonManagedReference
	private List<ExpenseType> expenseTypes;
	
	public Expense() {}
	
	public Expense(
			double amount, LocalDate date, String description, User user, Income income,
			List<ExpenseType> expenseTypes) {
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.user = user;
		this.income = income;
		this.expenseTypes = expenseTypes;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Income getIncome() {
		return income;
	}
	
	public void setIncome(Income income) {
		this.income = income;
	}
	
	public List<ExpenseType> getExpenseTypes() {
		return expenseTypes;
	}
	
	public void setExpenseTypes(List<ExpenseType> expenseTypes) {
		this.expenseTypes = expenseTypes;
	}
}