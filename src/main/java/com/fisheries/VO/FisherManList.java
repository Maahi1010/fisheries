package com.fisheries.VO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class FisherManList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fisher_man_id")
	private Integer fisherManId;
	
	@Column(name = "society_id")
	private Integer societyId;

	@Column(name = "fisher_man_name")
	private String fisherManName;
	
	@Column(name="fisher_man_father_name")
	private String fisherManFatherName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="society_id",insertable = false, updatable = false) // Make sure to specify insertable and updatable
	SocietyDataVO societyDataVO;


	public FisherManList() {
		super();
	}

	public FisherManList(Integer fisherManId, Integer societyId, String fisherManName, String fisherManFatherName,
			SocietyDataVO societyDataVO) {
		super();
		this.fisherManId = fisherManId;
		this.societyId = societyId;
		this.fisherManName = fisherManName;
		this.fisherManFatherName = fisherManFatherName;
		this.societyDataVO = societyDataVO;
	}

	public Integer getFisherManId() {
		return fisherManId;
	}

	public void setFisherManId(Integer fisherManId) {
		this.fisherManId = fisherManId;
	}

	public Integer getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
	}

	public String getFisherManName() {
		return fisherManName;
	}

	public void setFisherManName(String fisherManName) {
		this.fisherManName = fisherManName;
	}

	public String getFisherManFatherName() {
		return fisherManFatherName;
	}

	public void setFisherManFatherName(String fisherManFatherName) {
		this.fisherManFatherName = fisherManFatherName;
	}
	
	
}
