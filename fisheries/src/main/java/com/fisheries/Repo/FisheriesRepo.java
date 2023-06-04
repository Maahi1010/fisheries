package com.fisheries.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fisheries.VO.SocietyDataVO;


public interface FisheriesRepo extends JpaRepository<SocietyDataVO, Integer> {

}
