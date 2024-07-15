package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;
import kr.ac.kopo.reservation.dao.ReservationDAO;
import kr.ac.kopo.reservation.vo.ReservationVO;

public class ReservationController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDAO reservDao = new ReservationDAO();
		ReservationVO reservation = new ReservationVO();
		
		String db = request.getParameter("db");
		
		switch (db) {
		case "1":
			int movieNo = Integer.parseInt(request.getParameter("movieNo"));
			String seatName = request.getParameter("seatName");
			int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
			int headcount = Integer.parseInt(request.getParameter("headcount"));
			int payment = Integer.parseInt(request.getParameter("payment"));
			
			reservation.setMemberId("test");
			reservation.setMovieNo(movieNo);
			reservation.setSeatName(seatName);
			reservation.setScheduleNo(scheduleNo);
			reservation.setHeadcount(headcount);
			reservation.setPayment(payment);
			
			reservDao.insertToDB1(reservation);
			break;
		case "2":
			reservDao.insertToDB2(reservation);
			break;
		case "3":
			reservDao.insertToDB3(reservation);
			break;
		}

		return "/reservation/reservation.jsp";
	}

}
