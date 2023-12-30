package com.fisheries.VO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SocietyDataVO {
	@Id
	@Column(name = "society_id")
	private Integer societyId;

	@Column(name = "society_Name")
	private String societyName;

	@OneToMany(mappedBy = "societyDataVO", cascade = CascadeType.ALL)
    private List<FisherManList> fisherManList = new ArrayList<>();

	public Integer getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public List<FisherManList> getFisherManList() {
		return fisherManList;
	}

	public void setFisherManList(List<FisherManList> fisherManList) {
		this.fisherManList = fisherManList;
	}	

}
