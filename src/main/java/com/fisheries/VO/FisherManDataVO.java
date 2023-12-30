package com.fisheries.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FisherManDataVO {

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
	
	@Column(name="other_Mjr_Corp")
	private Integer otherMjrCorp;
	
	@Column(name="other_Mjr_Corp_wt")
	private Double otherMjrCorpWt;
	
	@Column(name="total_krm")
	private Integer totalKRM;
	
	@Column(name="total_krm_wt")
	private Double totalKRMWt;
	
	@Column(name="singhad")
	private Integer singhad;
	
	@Column(name="singhad_wt")
	private Double singhadWt;
	
	@Column(name="pabCheetSambKal")
	private Integer pabCheetSambKal;
	
	@Column(name="pabCheetSambKal_wt")
	private Double pabCheetSambKalWt;

	@Column(name="kalvasu")
	private Integer kalvasu;
	
	@Column(name="kalvasu_wt")
	private Double kalvasuWt;
	
	@Column(name="total_local_major")
	private Integer totalLocalMaj;
	
	@Column(name="total_local_major_wt")
	private Double totalLocalMajWt;
	
	@Column(name="big_minor")
	private Integer bigMinor;
	
	@Column(name="big_minor_wt")
	private Double bigMinorWt;
	
	@Column(name="minor_wt")
	private Double minorWt;
	
	@Column(name="total_minor")
	private Integer totalMinor;
	
	@Column(name="total_minor_wt")
	private Double totalMinorWt;
	
	@Column(name="grand_total")
	private Integer grandTotal;
	
	@Column(name="grand_total_wt")
	private Double grandTotalWt;
	


	public FisherManDataVO(Integer dataPkId, Integer fisherManId, Integer societyId, String societyName,
			String fisherManName, String fisherManFatherName, String dateOfWork, Integer katla, Double katlaWt,
			Integer rohu, Double rohuWt, Integer mrigal, Double mrigalWt, Integer otherMjrCorp, Double otherMjrCorpWt,
			Integer totalKRM, Double totalKRMWt, Integer singhad, Double singhadWt, Integer pabCheetSambKal,
			Double pabCheetSambKalWt, Integer kalvasu, Double kalvasuWt, Integer totalLocalMaj, Double totalLocalMajWt,
			Integer bigMinor, Double bigMinorWt, Double minorWt, Integer totalMinor, Double totalMinorWt,
			Integer grandTotal, Double grandTotalWt) {
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
		this.otherMjrCorp = otherMjrCorp;
		this.otherMjrCorpWt = otherMjrCorpWt;
		this.totalKRM = totalKRM;
		this.totalKRMWt = totalKRMWt;
		this.singhad = singhad;
		this.singhadWt = singhadWt;
		this.pabCheetSambKal = pabCheetSambKal;
		this.pabCheetSambKalWt = pabCheetSambKalWt;
		this.kalvasu = kalvasu;
		this.kalvasuWt = kalvasuWt;
		this.totalLocalMaj = totalLocalMaj;
		this.totalLocalMajWt = totalLocalMajWt;
		this.bigMinor = bigMinor;
		this.bigMinorWt = bigMinorWt;
		this.minorWt = minorWt;
		this.totalMinor = totalMinor;
		this.totalMinorWt = totalMinorWt;
		this.grandTotal = grandTotal;
		this.grandTotalWt = grandTotalWt;
	}

	public FisherManDataVO() {
		super();
	}

	public Integer getFisherManId() {
		return fisherManId;
	}

	public void setFisherManId(Integer fisherManId) {
		this.fisherManId = fisherManId;
	}
	public String getFisherManName() {
		return fisherManName;
	}

	public void setFisherManName(String fisherManName) {
		this.fisherManName = fisherManName;
	}

	public Integer getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
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

	public Integer getRohu() {
		return rohu;
	}

	public void setRohu(Integer rohu) {
		this.rohu = rohu;
	}

	public Integer getMrigal() {
		return mrigal;
	}

	public void setMrigal(Integer mrigal) {
		this.mrigal = mrigal;
	}

	public Integer getDataPkId() {
		return dataPkId;
	}

	public void setDataPkId(Integer dataPkId) {
		this.dataPkId = dataPkId;
	}

	public String getFisherManFatherName() {
		return fisherManFatherName;
	}

	public void setFisherManFatherName(String fisherManFatherName) {
		this.fisherManFatherName = fisherManFatherName;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public Double getKatlaWt() {
		return katlaWt;
	}

	public void setKatlaWt(Double katlaWt) {
		this.katlaWt = katlaWt;
	}

	public Double getRohuWt() {
		return rohuWt;
	}

	public void setRohuWt(Double rohuWt) {
		this.rohuWt = rohuWt;
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

	public Integer getSinghad() {
		return singhad;
	}

	public void setSinghad(Integer singhad) {
		this.singhad = singhad;
	}

	public Double getSinghadWt() {
		return singhadWt;
	}

	public void setSinghadWt(Double singhadWt) {
		this.singhadWt = singhadWt;
	}

	public Integer getPabCheetSambKal() {
		return pabCheetSambKal;
	}

	public void setPabCheetSambKal(Integer pabCheetSambKal) {
		this.pabCheetSambKal = pabCheetSambKal;
	}

	public Double getPabCheetSambKalWt() {
		return pabCheetSambKalWt;
	}

	public void setPabCheetSambKalWt(Double pabCheetSambKalWt) {
		this.pabCheetSambKalWt = pabCheetSambKalWt;
	}

	public Integer getBigMinor() {
		return bigMinor;
	}

	public void setBigMinor(Integer bigMinor) {
		this.bigMinor = bigMinor;
	}

	public Double getBigMinorWt() {
		return bigMinorWt;
	}

	public void setBigMinorWt(Double bigMinorWt) {
		this.bigMinorWt = bigMinorWt;
	}

	public Double getMinorWt() {
		return minorWt;
	}

	public void setMinorWt(Double minorWt) {
		this.minorWt = minorWt;
	}

	public Integer getTotalMinor() {
		return totalMinor;
	}

	public void setTotalMinor(Integer totalMinor) {
		this.totalMinor = totalMinor;
	}

	public Double getTotalMinorWt() {
		return totalMinorWt;
	}

	public void setTotalMinorWt(Double totalMinorWt) {
		this.totalMinorWt = totalMinorWt;
	}

	public Integer getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Integer grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Double getGrandTotalWt() {
		return grandTotalWt;
	}

	public void setGrandTotalWt(Double grandTotalWt) {
		this.grandTotalWt = grandTotalWt;
	}

	public Integer getOtherMjrCorp() {
		return otherMjrCorp;
	}

	public void setOtherMjrCorp(Integer otherMjrCorp) {
		this.otherMjrCorp = otherMjrCorp;
	}

	public Double getOtherMjrCorpWt() {
		return otherMjrCorpWt;
	}

	public void setOtherMjrCorpWt(Double otherMjrCorpWt) {
		this.otherMjrCorpWt = otherMjrCorpWt;
	}

	public Integer getKalvasu() {
		return kalvasu;
	}

	public void setKalvasu(Integer kalvasu) {
		this.kalvasu = kalvasu;
	}

	public Double getKalvasuWt() {
		return kalvasuWt;
	}

	public void setKalvasuWt(Double kalvasuWt) {
		this.kalvasuWt = kalvasuWt;
	}

	public Integer getTotalLocalMaj() {
		return totalLocalMaj;
	}

	public void setTotalLocalMaj(Integer totalLocalMaj) {
		this.totalLocalMaj = totalLocalMaj;
	}

	public Double getTotalLocalMajWt() {
		return totalLocalMajWt;
	}

	public void setTotalLocalMajWt(Double totalLocalMajWt) {
		this.totalLocalMajWt = totalLocalMajWt;
	}

	
}
