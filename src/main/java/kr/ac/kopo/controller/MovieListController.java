package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;

public class MovieListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String db = request.getParameter("db");
		
		MovieDAO movieDao = new MovieDAO();
		List<MovieVO> movieList = new ArrayList<>();

		switch (db) {
		case "1":
			movieList = movieDao.selectAllFromDB1();
			break;
		case "2":
			movieList = movieDao.selectAllFromDB2();
			break;
		case "3":
			movieList = movieDao.selectAllFromDB3();
			break;
		}

		// Gson 라이브러리 사용하여 JSON 문자열 생성
		Gson gson = new Gson();
		String jsonString = gson.toJson(movieList);

		// JSON 문자열 응답 전송
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Max-Age", "3600");
		
		request.setAttribute("jsonString", jsonString);
		
		return "/movie/list.jsp";
	}

}
