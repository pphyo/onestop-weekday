package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.location.model.entity.Division;

public interface DivisionRepo extends JpaRepositoryImplementation<Division, Integer>{

	@Query("select distinct d.region from Division d order by d.region")
	List<String> findAllRegions();

}
