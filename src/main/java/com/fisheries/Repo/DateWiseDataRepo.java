package com.fisheries.Repo;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fisheries.VO.FisherManDataVO;

public interface DateWiseDataRepo  extends JpaRepository<FisherManDataVO, Integer>{
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value =
	 * "SELECT * FROM Fisher_Man_DataVO where fisher_man_id =? and society_id=? and date_of_work=?"
	 * ,nativeQuery = true) List<FisherManDataVO>
	 * findDatabyDate(@Param("fisher_man_id")Integer
	 * fisherManId, @Param("society_id")Integer society_id, @Param("date_of_work")
	 * Date dateOfWork);
	 */
	//List<FisherManDataVO> findDatabyDateAndSocietyId(Integer society_id, String dateOfWork);

}
