package com.fisheries.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FisherManDataVO {

	@Id
	@Column(name = "fisher_man_id")
	private Integer fisherManId;
	
	@Column(name = "society_id")
	private Integer societyId;

	@Column(name = "fisher_man_name")
	private String fisherManName;

	public Integer getFisherManId() {
		return fisherManId;
	}

	public void setFisherManId(Integer fisherManId) {
		this.fisherManId = fisherManId;
	}

	public Integer getSociety_id() {
		return societyId;
	}

	public void setSociety_id(Integer society_id) {
		this.societyId = society_id;
	}

	public String getFisherManName() {
		return fisherManName;
	}

	public void setFisherManName(String fisherManName) {
		this.fisherManName = fisherManName;
	}

	
}
