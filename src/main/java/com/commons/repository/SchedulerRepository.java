package com.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.commons.entity.Scheduler;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Long>, JpaSpecificationExecutor<Scheduler>{

}

