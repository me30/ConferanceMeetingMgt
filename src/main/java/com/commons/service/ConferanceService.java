package com.commons.service;

import com.commons.model.DataTableJsonObject;

public interface ConferanceService {

	DataTableJsonObject featchAll(String searchCol, String orderDirection, String searchParameter, Integer startRec, Integer pageDisplayLength, Integer pageNumber);

}
