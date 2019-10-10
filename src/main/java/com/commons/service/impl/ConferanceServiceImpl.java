package com.commons.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.entity.Duration;
import com.commons.entity.MeetingRoomDetails;
import com.commons.entity.Scheduler;
import com.commons.model.DataTableJsonObject;
import com.commons.repository.DurationRepository;
import com.commons.repository.MeetingRoomDetailsRepository;
import com.commons.repository.SchedulerRepository;
import com.commons.service.ConferanceService;
import com.commons.service.SchedulerService;

@Service
public class ConferanceServiceImpl implements ConferanceService{

	@Autowired
	SchedulerRepository schedulerRepository;

	@Autowired
	DurationRepository durationRepository;

	@Autowired
	MeetingRoomDetailsRepository meetingRoomDetailsRepository;

	@Override
	public DataTableJsonObject featchAll(String searchCol, String orderDirection, String searchParameter,
			Integer startRec, Integer pageDisplayLength, Integer pageNumber) {

		List<Scheduler> dataList = schedulerRepository.findAll();
		DataTableJsonObject dt = new DataTableJsonObject();
		dt.setAaData(dataList);
		dt.setiTotalRecords(dataList.size());
		dt.setiTotalDisplayRecords(dataList.size());
		return dt;
	}

	@Override
	public DataTableJsonObject search(
			String searchCol, String orderDirection, String searchParameter, Integer startRec, Integer pageDisplayLength, Integer pageNumber, String location, int durationid, String time, Date date) {

		//To Do ::1 find booked scheduler data..
		//List<Scheduler> bookedSchedule = schedulerRepository.findByTodayAfterCurrentTime(new Date().getTime(), new Date());

		//To Do :: create list for data which not booked for today...
		List<Duration> durationList = durationRepository.findAll();
		List<MeetingRoomDetails> meetingRoomDetailsList = meetingRoomDetailsRepository.findByLocationOrderByNameDesc(location);

		List<Scheduler> dataSet = new ArrayList<Scheduler>(0); 
		for (Duration duration : durationList) {
			for (MeetingRoomDetails meetingRoomDetails : meetingRoomDetailsList) {
				Scheduler s = new Scheduler();
				s.setId(new Integer(0));
				s.setEventName("-");
				s.setDuration(duration);
				s.setMeetingRoomDetails(meetingRoomDetails);
				s.setOwner(null);
				dataSet.add(s);
			}
		}

		DataTableJsonObject dt = new DataTableJsonObject();
		dt.setAaData(dataSet);
		dt.setiTotalRecords(dataSet.size());
		dt.setiTotalDisplayRecords(dataSet.size());

		return dt;
	}

	@Override
	public List<Duration> fetchAllDuration() {
		return durationRepository.findAll();
	}
}
