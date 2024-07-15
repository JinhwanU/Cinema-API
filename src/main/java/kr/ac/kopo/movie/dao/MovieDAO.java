package kr.ac.kopo.movie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.movie.vo.MovieVO;
import kr.ac.kopo.util.MyBatisConfig;

public class MovieDAO {
	private SqlSession session;

	public MovieDAO() {
//		session = new MyBatisConfig().getInstance();
	}

	public List<MovieVO> selectAllFromDB1() {
		session = new MyBatisConfig().getInstanceDB1();
		List<MovieVO> list = session.selectList("movie.dao.MovieDAO.selectAllFromDB1");
		return list;
	}

	public List<MovieVO> selectAllFromDB2() {
		session = new MyBatisConfig().getInstanceDB2();
		List<MovieVO> list = session.selectList("movie.dao.MovieDAO.selectAllFromDB2");
		return list;
	}

	public List<MovieVO> selectAllFromDB3() {
		session = new MyBatisConfig().getInstanceDB3();
		List<MovieVO> list = session.selectList("movie.dao.MovieDAO.selectAllFromDB3");
		return list;
	}
}
