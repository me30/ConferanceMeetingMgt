package com.commons.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commons.entity.Scheduler;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Long>, JpaSpecificationExecutor<Scheduler>{

	@Query("select s from Scheduler s where s.duration.startTime > ?1 and s.scheduleDate = ?2")
	List<Scheduler> findByTodayAfterCurrentTime(long nowtime, Date date);

}

