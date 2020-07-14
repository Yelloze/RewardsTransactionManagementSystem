package com.in28minutes.fullstack.springboot.maven.crud.springbootcrudfullstackwithmaven.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductRewardsService {

	private static List<Customer> customers = new ArrayList<>();
	private static long idCounter = 0;
	private static int rewards=0;
	private static int rewards2=0;




	static {

		Customer cust1 = new Customer(++idCounter, "PROD101", 120, 0);
		Customer cust2 = new Customer(++idCounter, "PROD102", 110, 0);
		Customer cust3 = new Customer(++idCounter, "PROD103", 50, 0);
		Customer cust4 = new Customer(++idCounter, "PROD103", 10, 0);

		if(cust1.getTransAmount()>49 && cust1.getTransAmount()<100) {
			rewards=cust1.getTransAmount()*1;

			cust1.setRewards(rewards);
		}
		else if(cust1.getTransAmount()>=100)
		{
			rewards=50*1;
			rewards=rewards*1;
			System.out.println("Rewards1 ::::"+rewards);

			rewards2=cust1.getTransAmount()-100;
			rewards2=rewards2*2;
			System.out.println("Rewards2 ::::"+rewards2);
			cust1.setRewards(rewards2+rewards);
		}
		customers.add(cust1);


		if(cust2.getTransAmount()>49 && cust2.getTransAmount()<100) {
			rewards=cust2.getTransAmount()*1;
			cust2.setRewards(rewards);
		}
		else if(cust2.getTransAmount()>=100)
		{
			rewards=50*1;
			rewards=rewards*1;
			System.out.println("Rewards1 ::::"+rewards);

			rewards2=cust2.getTransAmount()-100;
			rewards2=rewards2*2;
			System.out.println("Rewards2 ::::"+rewards2);
			cust2.setRewards(rewards2+rewards);
		}


		customers.add(cust2);

		if(cust3.getTransAmount()>49 && cust3.getTransAmount()<100) {
			rewards=cust3.getTransAmount()*1;
			System.out.println("Rewards3 ::::"+rewards);
			cust3.setRewards(rewards);
		}
		else if(cust3.getTransAmount()>=100)
		{
			rewards=50*1;
			rewards=rewards*1;
			System.out.println("Rewards3 ::::"+rewards);

			rewards2=cust3.getTransAmount()-100;
			rewards2=rewards2*2;
			System.out.println("Rewards2 ::::"+rewards2);
			cust3.setRewards(rewards2+rewards);
		}
		customers.add(cust3);

		if(cust4.getTransAmount()>49 && cust4.getTransAmount()<100) {
			rewards=cust4.getTransAmount()*1;
			System.out.println("Rewards3 ::::"+rewards);
			cust4.setRewards(rewards);
		}
		else if(cust4.getTransAmount()>=100)
		{
			rewards=50*1;
			rewards=rewards*1;
			System.out.println("Rewards3 ::::"+rewards);

			rewards2=cust4.getTransAmount()-100;
			rewards2=rewards2*2;
			System.out.println("Rewards2 ::::"+rewards2);
			cust4.setRewards(rewards2+rewards);
		}
		customers.add(cust4);


	}




	public List<Customer> findAll() {
		return customers;
	}

	public Customer save(Customer customer) {
		if (customer.getId() == -1 || customer.getId() == 0) {
			customer.setId(++idCounter);
			customers.add(customer);

		} else {
			deleteById(customer.getId());
			customers.add(customer);
		}
		return  customer;
	}

	public Customer deleteById(long id) {
		Customer customer = findById(id);

		if (customer == null)
			return null;

		if (customers.remove(customer)) {
			return customer;
		}

		return null;
	}

	public Customer findById(long id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}

		return null;
	}
}