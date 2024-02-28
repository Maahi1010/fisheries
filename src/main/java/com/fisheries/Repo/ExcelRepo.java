package com.fisheries.Repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fisheries.VO.FisherManDataVO;
import com.fisheries.VO.WeeklyReportVO;

@Repository
public interface ExcelRepo extends JpaRepository<FisherManDataVO, Integer> {

	@Query("SELECT NEW com.fisheries.VO.FisherManDataVO (\r\n" + "    datas.dataPkId, \r\n"
			+ "    listi.fisherManId, \r\n" + "    listi.societyId,  \r\n" + "    datas.societyName, \r\n"
			+ "    listi.fisherManName, \r\n" + "    listi.fisherManFatherName, \r\n" + "    datas.dateOfWork, \r\n"
			+ "    datas.katla, \r\n" + "    datas.katlaWt, \r\n" + "    datas.rohu, \r\n" + "    datas.rohuWt, \r\n"
			+ "    datas.mrigal, \r\n" + "    datas.mrigalWt, \r\n" + "    datas.otherMjrCorp, \r\n"
			+ "    datas.otherMjrCorpWt, \r\n" + "    datas.totalKRM, \r\n" + "    datas.totalKRMWt,\r\n"
			+ "    datas.singhad,\r\n" + "    datas.singhadWt,\r\n" + "    datas.pabCheetSambKal,\r\n"
			+ "    datas.pabCheetSambKalWt,\r\n" + "    datas.kalvasu,\r\n" + "    datas.kalvasuWt,\r\n"
			+ "    datas.totalLocalMaj,\r\n" + "    datas.totalLocalMajWt,\r\n" + "    datas.bigMinor,\r\n"
			+ "    datas.bigMinorWt,\r\n" + "    datas.minorWt,\r\n" + "    datas.totalMinor,\r\n"
			+ "    datas.totalMinorWt,\r\n" + "    datas.grandTotal,\r\n" + "    datas.grandTotalWt\r\n" + ")\r\n"
			+ "FROM com.fisheries.VO.FisherManList listi \r\n" + "LEFT JOIN com.fisheries.VO.FisherManDataVO datas \r\n"
			+ "ON listi.fisherManId = datas.fisherManId AND datas.dateOfWork = :dateOfWork \r\n"
			+ "WHERE listi.societyId = :societyId \r\n" + "ORDER BY listi.fisherManId")
	List<FisherManDataVO> findByDateOfWorkAndSocietyId(@Param("dateOfWork") String dateOfWork,

			@Param("societyId") Integer societyId);

	@Query(value = "SELECT \r\n" + "" + "		           all_dates.dateOfWork as dateOfWork, \r\n"
			+ "		          COALESCE(SUM(f.total_krm_wt), 0) as totalKRMWt, \r\n"
			+ "		           COALESCE(SUM(f.total_local_major_wt), 0) as totalLocalMajWt, \r\n"
			+ "		           COALESCE(SUM(f.total_minor_wt), 0) as totalMinorWt, \r\n"
			+ "		           COALESCE(SUM(f.big_minor_wt), 0) as bigMinorWt, \r\n"
			+ "		           COALESCE(SUM(f.grand_total_wt), 0) as grandTotalWt \r\n" + "		       FROM \r\n"
			+ "		           (\r\n"
			+ "		               SELECT DATE_ADD(:fromDate, INTERVAL t DAY) as dateOfWork \r\n"
			+ "		               FROM (SELECT 0 t UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 "
			+ ") days   " + "  ) all_dates LEFT JOIN fisher_man_datavo f ON all_dates.dateOfWork = f.date_of_work \r\n"
			+ "		       WHERE\r\n" + "		           all_dates.dateOfWork BETWEEN :fromDate AND :toDate \r\n"
			+ "		       GROUP BY \r\n" + "		          all_dates.dateOfWork", nativeQuery = true)
	List<WeeklyReportVO> findByWeek(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT \r\n"
			+ "    all_dates.dateOfWork as dateOfWork,\r\n"
			+ "    COALESCE(SUM(f.total_krm_wt), 0) as totalKRMWt,\r\n"
			+ "    COALESCE(SUM(f.total_local_major_wt), 0) as totalLocalMajWt,\r\n"
			+ "    COALESCE(SUM(f.total_minor_wt), 0) as totalMinorWt,\r\n"
			+ "    COALESCE(SUM(f.big_minor_wt), 0) as bigMinorWt,\r\n"
			+ "    COALESCE(SUM(f.grand_total_wt), 0) as grandTotalWt\r\n"
			+ "FROM (\r\n"
			+ "    SELECT DATE_ADD(':fromDate', INTERVAL t DAY) as dateOfWork\r\n"
			+ "    FROM (\r\n"
			+ "        SELECT t\r\n"
			+ "        FROM (\r\n"
			+ "            SELECT (ROW_NUMBER() OVER ()) - 1 as t\r\n"
			+ "            FROM information_schema.tables\r\n"
			+ "            LIMIT 365\r\n"     /*-- Adjust based on the maximum number of days in the range */
			+ "        ) numbered_days\r\n"
			+ "        WHERE DATE_ADD(':fromDate', INTERVAL t DAY) <= :toDate\r\n"
			+ "    ) days\r\n"
			+ ") all_dates\r\n"
			+ "LEFT JOIN fisher_man_datavo f ON DATE_FORMAT(all_dates.dateOfWork, '%Y-%m-%d') = DATE_FORMAT(f.date_of_work, '%Y-%m-%d')\r\n"
			+ "WHERE all_dates.dateOfWork BETWEEN :fromDate AND :toDate\r\n"
			+ "GROUP BY all_dates.dateOfWork;\r\n"
			, nativeQuery = true)
	List<WeeklyReportVO> findByMonth(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
