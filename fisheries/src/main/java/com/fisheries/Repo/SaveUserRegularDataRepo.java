package com.fisheries.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fisheries.VO.FisherManDataVO;

@Repository
public interface SaveUserRegularDataRepo extends JpaRepository<FisherManDataVO,Integer> {

	@Query(value = "select f from FisherManDataVO f where f.fisherManId = :fisherManId and f.dateOfWork = :dateOfWork")
	FisherManDataVO findByfisherManIdanddateOfWork(Integer fisherManId, String dateOfWork);

}
