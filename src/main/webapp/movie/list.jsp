<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.ac.kopo.movie.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.movie.dao.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String jsonString = (String)request.getAttribute("jsonString");
response.getWriter().write(jsonString);
%>