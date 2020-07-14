package com.in28minutes.fullstack.springboot.maven.crud.springbootcrudfullstackwithmaven.course;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CustomerResource {

	@Autowired
	private ProductRewardsService productRewardsService;

	@GetMapping("/instructors/{product}/customers")
	public List<Customer> retrieveAllCustomers(@PathVariable String product) {
		return productRewardsService.findAll();
	}

	@GetMapping("/instructors/{product}/customers/{id}")
	public Customer retrieveCustomers(@PathVariable String product, @PathVariable long id) {
		return productRewardsService.findById(id);
	}

	@DeleteMapping("/instructors/{product}/customers/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable String product, @PathVariable long id) {

		Customer customer = productRewardsService.deleteById(id);

		if (customer != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/instructors/{product}/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String product, @PathVariable long id,
			@RequestBody Customer customer) {

		Customer courseUpdated = productRewardsService.save(customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PostMapping("/instructors/{product}/customer")
	public ResponseEntity<Void> createPurchase(@PathVariable String product, @RequestBody Customer customer) {

		Customer createdPurchase = productRewardsService.save(customer);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPurchase.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}