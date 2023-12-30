package com.fisheries.VO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ResultExcelDataFromDb {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "data_pk_id")
	private Integer dataPkId;
	
	@Column(name = "fisher_man_id")
	private Integer fisherManId;
	
	@Column(name = "society_id")
	private Integer societyId ;

	@Column(name = "society_name")
	private String societyName;

	@Column(name = "fisher_man_name")
	private String fisherManName;
	
	@Column(name="fisher_man_father_name")
	private String fisherManFatherName;
	
	@Column(name="date_of_work")
	private String dateOfWork;
	
	@Column(name="katla")
	private Integer katla;
	
	@Column(name="katla_wt")
	private Double katlaWt;
	
	@Column(name="rohu")
	private Integer rohu;
	
	@Column(name="rohu_wt")
	private Double rohuWt;
	
	@Column(name="mrigal")
	private Integer mrigal;
	
	@Column(name="mrigal_wt")
	private Double mrigalWt;
	
	@Column(name="total_krm")
	private Integer totalKRM;
	
	@Column(name="total_krm_wt")
	private Double totalKRMWt;

	
	
	public ResultExcelDataFromDb(Integer dataPkId, Integer fisherManId, Integer societyId, String societyName,
			String fisherManName, String fisherManFatherName, String dateOfWork, Integer katla, Double katlaWt,
			Integer rohu, Double rohuWt, Integer mrigal, Double mrigalWt, Integer totalKRM, Double totalKRMWt) {
		super();
		this.dataPkId = dataPkId;
		this.fisherManId = fisherManId;
		this.societyId = societyId;
		this.societyName = societyName;
		this.fisherManName = fisherManName;
		this.fisherManFatherName = fisherManFatherName;
		this.dateOfWork = dateOfWork;
		this.katla = katla;
		this.katlaWt = katlaWt;
		this.rohu = rohu;
		this.rohuWt = rohuWt;
		this.mrigal = mrigal;
		this.mrigalWt = mrigalWt;
		this.totalKRM = totalKRM;
		this.totalKRMWt = totalKRMWt;
	}

	public ResultExcelDataFromDb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDataPkId() {
		return dataPkId;
	}

	public void setDataPkId(Integer dataPkId) {
		this.dataPkId = dataPkId;
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

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
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

	public String getDateOfWork() {
		return dateOfWork;
	}

	public void setDateOfWork(String dateOfWork) {
		this.dateOfWork = dateOfWork;
	}

	public Integer getKatla() {
		return katla;
	}

	public void setKatla(Integer katla) {
		this.katla = katla;
	}

	public Double getKatlaWt() {
		return katlaWt;
	}

	public void setKatlaWt(Double katlaWt) {
		this.katlaWt = katlaWt;
	}

	public Integer getRohu() {
		return rohu;
	}

	public void setRohu(Integer rohu) {
		this.rohu = rohu;
	}

	public Double getRohuWt() {
		return rohuWt;
	}

	public void setRohuWt(Double rohuWt) {
		this.rohuWt = rohuWt;
	}

	public Integer getMrigal() {
		return mrigal;
	}

	public void setMrigal(Integer mrigal) {
		this.mrigal = mrigal;
	}

	public Double getMrigalWt() {
		return mrigalWt;
	}

	public void setMrigalWt(Double mrigalWt) {
		this.mrigalWt = mrigalWt;
	}

	public Integer getTotalKRM() {
		return totalKRM;
	}

	public void setTotalKRM(Integer totalKRM) {
		this.totalKRM = totalKRM;
	}

	public Double getTotalKRMWt() {
		return totalKRMWt;
	}

	public void setTotalKRMWt(Double totalKRMWt) {
		this.totalKRMWt = totalKRMWt;
	}
	
}
