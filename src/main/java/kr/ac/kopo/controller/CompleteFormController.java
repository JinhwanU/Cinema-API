package kr.ac.kopo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.reservation.dao.ReservationDAO;
import kr.ac.kopo.reservation.vo.ReservationVO;
import kr.ac.kopo.seat.dao.SeatDAO;
import kr.ac.kopo.seat.vo.SeatVO;

public class CompleteFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		StringBuilder jsonBuilder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			jsonBuilder.append(line);
		}
		String jsonInputString = jsonBuilder.toString();

		// JSON 데이터 파싱
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(jsonInputString, JsonObject.class);

		// seatList와 reservation 추출
		Type seatListType = new TypeToken<List<SeatVO>>() {
		}.getType();
		List<SeatVO> seatList = gson.fromJson(jsonObject.get("seatList"), seatListType);
		ReservationVO reservation = gson.fromJson(jsonObject.get("reservation"), ReservationVO.class);
		System.out.println(reservation);
		String db = request.getParameter("db");

		ReservationDAO reservDao = new ReservationDAO();
		SeatDAO seatDao = new SeatDAO();
		System.out.println(seatList.toString());
		switch (db) {
		case "1":
			seatDao.updateAvailableToDB1(seatList);
			reservDao.insertToDB1(reservation);
			break;
		case "2":
			seatDao.updateAvailableToDB2(seatList);
			reservDao.insertToDB2(reservation);
			break;
		case "3":
			for (SeatVO seat : seatList)
				seat.setTheaterName("1");
			seatDao.updateAvailableToDB3(seatList);
			reservDao.insertToDB3(reservation);
			break;
		}
		return "/reservation/insert.jsp";
			
	}

}
