package com.fisheries.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fisheries.VO.FisherManDataVO;

public interface ExcelRepo extends JpaRepository<FisherManDataVO, Integer> {

	@Query("SELECT NEW com.fisheries.VO.FisherManDataVO (\r\n"
			+ "    datas.dataPkId, \r\n"
			+ "    listi.fisherManId, \r\n"
			+ "    listi.societyId,  \r\n"
			+ "    datas.societyName, \r\n"
			+ "    listi.fisherManName, \r\n"
			+ "    listi.fisherManFatherName, \r\n"
			+ "    datas.dateOfWork, \r\n"
			+ "    datas.katla, \r\n"
			+ "    datas.katlaWt, \r\n"
			+ "    datas.rohu, \r\n"
			+ "    datas.rohuWt, \r\n"
			+ "    datas.mrigal, \r\n"
			+ "    datas.mrigalWt, \r\n"
			+ "    datas.otherMjrCorp, \r\n"
			+ "    datas.otherMjrCorpWt, \r\n"
			+ "    datas.totalKRM, \r\n"
			+ "    datas.totalKRMWt,\r\n"
			+ "    datas.singhad,\r\n"
			+ "    datas.singhadWt,\r\n"
			+ "    datas.pabCheetSambKal,\r\n"
			+ "    datas.pabCheetSambKalWt,\r\n"
			+ "    datas.kalvasu,\r\n"
			+ "    datas.kalvasuWt,\r\n"
			+ "    datas.totalLocalMaj,\r\n"
			+ "    datas.totalLocalMajWt,\r\n"
			+ "    datas.bigMinor,\r\n"
			+ "    datas.bigMinorWt,\r\n"
			+ "    datas.minorWt,\r\n"
			+ "    datas.totalMinor,\r\n"
			+ "    datas.totalMinorWt,\r\n"
			+ "    datas.grandTotal,\r\n"
			+ "    datas.grandTotalWt\r\n"
			+ ")\r\n"
			+ "FROM com.fisheries.VO.FisherManList listi \r\n"
			+ "LEFT JOIN com.fisheries.VO.FisherManDataVO datas \r\n"
			+ "ON listi.fisherManId = datas.fisherManId AND datas.dateOfWork = :dateOfWork \r\n"
			+ "WHERE listi.societyId = :societyId \r\n"
			+ "ORDER BY listi.fisherManId")
	List<FisherManDataVO> findByDateOfWorkAndSocietyId(@Param("dateOfWork") String dateOfWork,

			@Param("societyId") Integer societyId);

	/*
	 * @Query("SELECT datas FROM FisherManList listi " +
	 * "LEFT JOIN ResultExcelDataFromDb datas " +
	 * "ON listi.fisherManId = datas.fisherManId " +
	 * "AND datas.dateOfWork = :dateOfWork " + "WHERE listi.societyId = :societyId "
	 * + "ORDER BY listi.fisherManId") List<ResultExcelDataFromDb>
	 * findByDateOfWorkAndSocietyId(@Param("dateOfWork") String dateOfWork,
	 * 
	 * @Param("societyId") Integer societyId);
	 */
}
