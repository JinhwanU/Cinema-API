package kr.ac.kopo.reservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.reservation.vo.ReservationVO;
import kr.ac.kopo.util.MyBatisConfig;

public class ReservationDAO {
	private SqlSession session;

	public ReservationDAO() {
//		session = new MyBatisConfig().getInstance();
	}

	public void insertToDB1(ReservationVO reservation) {
		try {
			session = new MyBatisConfig().getInstanceDB1();
			session.insert("reservation.dao.ReservationDAO.insertToDB1", reservation);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		}
	}
	public void insertToDB2(ReservationVO reservation) {
		try {
			session = new MyBatisConfig().getInstanceDB2();
			session.insert("reservation.dao.ReservationDAO.insertToDB2", reservation);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		}
	}
	public void insertToDB3(ReservationVO reservation) {
		try {
			session = new MyBatisConfig().getInstanceDB3();
			session.insert("reservation.dao.ReservationDAO.insertToDB3", reservation);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		}
	}
	
	
	public List<ReservationVO> selectListByMemberId(String memberId){
		List<ReservationVO> reservList= session.selectList("reservation.dao.ReservationDAO.selectListByMemberId", memberId);
		return reservList;
	}
}
