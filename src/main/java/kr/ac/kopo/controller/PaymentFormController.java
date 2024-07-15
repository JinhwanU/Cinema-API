package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.schedule.dao.ScheduleDAO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class PaymentFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String db = request.getParameter("db");
		int no = Integer.parseInt(request.getParameter("no"));
		ScheduleDAO scheduleDao = new ScheduleDAO();
		ScheduleVO schedule = new ScheduleVO();

		switch (db) {
		case "1":
			schedule = scheduleDao.selectByNoFromDB1(no);
			break;
		case "2":
			schedule = scheduleDao.selectByNoFromDB2(no);
			break;
		case "3":
			schedule = scheduleDao.selectByNoFromDB3(no);
			break;
		}
		// Gson 라이브러리 사용하여 JSON 문자열 생성
		Gson gson = new Gson();
		String jsonString = gson.toJson(schedule);
		
		// JSON 문자열 응답 전송
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Max-Age", "3600");

		request.setAttribute("jsonString", jsonString);
		
		return "/schedule/one.jsp";
	}

}
