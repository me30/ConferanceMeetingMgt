package com.commons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entity.Scheduler;
import com.commons.model.DataTableJsonObject;
import com.commons.service.ConferanceService;
import com.commons.service.SchedulerService;

@Service
public class ConferanceServiceImpl implements ConferanceService{

	@Autowired
	SchedulerService schedulerService;
	
	@Override
	public DataTableJsonObject featchAll(String searchCol, String orderDirection, String searchParameter,
			Integer startRec, Integer pageDisplayLength, Integer pageNumber) {
		
		List<Scheduler> dataList = schedulerService.findAll();
		DataTableJsonObject dt = new DataTableJsonObject();
		dt.setAaData(dataList);
		dt.setiTotalRecords(dataList.size());
		dt.setiTotalDisplayRecords(dataList.size());
		return dt;
	}

}
