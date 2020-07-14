package com.in28minutes.fullstack.springboot.maven.crud.springbootcrudfullstackwithmaven.course;

public class Customer {
	private Long id;
	private String product;
	private int transAmount;
	private int rewards;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(int transAmount) {
		this.transAmount = transAmount;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}



	public Customer(Long id, String product, int transAmount,int rewards) {
		this.id = id;
		this.product = product;
		this.transAmount = transAmount;
		this.rewards=rewards;

	}

	public Customer() {

	}

	


}