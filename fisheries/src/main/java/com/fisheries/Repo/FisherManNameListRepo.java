package com.fisheries.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fisheries.VO.FisherManDataVO;


public interface FisherManNameListRepo extends JpaRepository<FisherManDataVO, Integer>{

	/*
	 * @Query("SELECT * FROM fisher_man_datavo WHERE Society_id=1")
	 * List<FisherManDataVO> getFisherManNameList(String query);
	 */
	List<FisherManDataVO> findBySocietyId(int id);

}
