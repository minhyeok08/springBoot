package com.sist.web.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;
import java.util.*;
@Repository
public interface LocationDAO extends JpaRepository<SeoulLocationEntity,Integer>{
	@Query(value="SELECT * FROM seoul_location "
			+ "ORDER BY no asc "
			+ "LIMIT :start , 12",nativeQuery = true)
	public List<SeoulLocationEntity> SeoulFindData(int start);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location "
			,nativeQuery = true)
	public int SeoulTotalPage();
	
	//public SeoulLocationEntity ByInfoNo(@Param("no") Integer no);
}
