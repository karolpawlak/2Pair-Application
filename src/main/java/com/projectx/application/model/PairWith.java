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
@Table(name = "pairwith")
@Getter @Setter
public class PairWith {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid", referencedColumnName = "id")
	private Products productid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private Users userid;

	PairWith() {}

	PairWith(Products productid, Users userid) {
		this.productid = productid;
		this.userid = userid;
	}
}
