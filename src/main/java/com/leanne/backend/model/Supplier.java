package com.leanne.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierId;
	private String supplierName;
	private int supplierContact;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(int supplierContact) {
		this.supplierContact = supplierContact;
	}

}