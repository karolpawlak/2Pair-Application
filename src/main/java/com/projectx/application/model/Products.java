package com.projectx.application.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Data
@Entity
@Table(name = "products")
@Getter @Setter
public class Products {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lead", referencedColumnName = "id")
	private Users lead;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "domainid", referencedColumnName = "id")
	private Domains domain;
	
	@OneToOne(mappedBy = "productid")
	private Subcomponents subcomponent;
	
	@OneToOne(mappedBy = "productid")
	private PairWith pairwith;
	
	@OneToOne(mappedBy = "productid")
	private LookForHelp lookforhelp;
	
	Products() {}

	Products(String name, Users lead, Domains domain) {
		this.name = name;
		this.lead = lead;
		this.domain = domain;
	}
}
