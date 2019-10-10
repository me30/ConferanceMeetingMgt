package com.commons.service;

import java.util.Date;
import java.util.List;

import com.commons.entity.Duration;
import com.commons.model.DataTableJsonObject;

public interface ConferanceService {

	DataTableJsonObject featchAll(String searchCol, String orderDirection, String searchParameter, Integer startRec, Integer pageDisplayLength, Integer pageNumber);

	List<Duration> fetchAllDuration();

	DataTableJsonObject search(String searchCol, String orderDirection, String searchParameter, Integer startRec, Integer pageDisplayLength, Integer pageNumber, String location, int durationid, String time, Date date);
}
