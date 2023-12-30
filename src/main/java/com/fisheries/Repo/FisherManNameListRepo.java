package com.fisheries.Repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fisheries.VO.FisherManDataVO;
import com.fisheries.VO.FisherManList;


public interface FisherManNameListRepo extends JpaRepository<FisherManList, Integer>{

	List<FisherManList> findBySocietyId(Integer id);
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value="SELECT * FROM fisher_man_list WHERE Society_id=1",nativeQuery =
	 * true) List<FisherManList> findBySocietyId(int id);
	 */
	/*
	 * @Query("SELECT * FROM fisher_man_datavo WHERE Society_id=1")
	 * List<FisherManDataVO> getFisherManNameList(String query);
	 */
	//List<FisherManList> findBySocietyId(int id);

}
