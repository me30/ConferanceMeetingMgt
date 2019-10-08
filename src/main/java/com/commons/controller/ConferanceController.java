package com.commons.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.commons.model.DataTableJsonObject;
import com.commons.service.ConferanceService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ConferanceController {
	
	@Autowired
	ConferanceService conferanceService;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@RequestMapping(value = { "/fetchAll" }, method = RequestMethod.POST)
	public @ResponseBody String featchAll(ModelMap modelMap) throws Exception {
		String json = "";
		try {
			// Fetch Page display length
			Integer pageDisplayLength = Integer.valueOf(httpServletRequest.getParameter("iDisplayLength"));

			// Fetch the page number from client
			Integer pageNumber;
			if (null != httpServletRequest.getParameter("iDisplayStart")) {
				pageNumber = (Integer.valueOf(httpServletRequest.getParameter("iDisplayStart")) / pageDisplayLength)+ 1;
			} else {
				pageNumber = 0;
			}
			Integer startRec = (pageNumber * pageDisplayLength) - pageDisplayLength;

			// Fetch search parameter
			String searchParameter = httpServletRequest.getParameter("sSearch");

			// Fetch Sort Column
			String[] cols = { "id", "passportType", "applicantName", "applicationStatus", "status", "dateOfApplication",
					"nationalId" };
			int sCol = Integer.parseInt(httpServletRequest.getParameter("iSortCol_0"));

			// Fetch Sort Column order
			String orderDirection = httpServletRequest.getParameter("sSortDir_0");

			DataTableJsonObject jsonobj = conferanceService.featchAll(cols[sCol], orderDirection,
					searchParameter, startRec, pageDisplayLength, pageNumber);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			json = gson.toJson(jsonobj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
