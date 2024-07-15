package kr.ac.kopo.seat.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.schedule.vo.ScheduleVO;
import kr.ac.kopo.seat.vo.SeatVO;
import kr.ac.kopo.util.MyBatisConfig;

public class SeatDAO {
	private SqlSession session;

	public SeatDAO() {
//		session = new MyBatisConfig().getInstance();
	}

	public void updateAvailableToDB1(List<SeatVO> seatList) throws Exception {
		try {
			session = new MyBatisConfig().getInstanceDB1();

			int updatedRowCnt = 0;

			for (SeatVO seat : seatList) {
				int rowsUpdated = session.update("seat.dao.SeatDAO.updateAvailableToDB1", seat);
				updatedRowCnt += rowsUpdated;
			}

			if (updatedRowCnt < seatList.size()) {
				throw new Exception("Update failed.");
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		}
	}

	public void updateAvailableToDB2(List<SeatVO> seatList) throws Exception {
		try {
			session = new MyBatisConfig().getInstanceDB2();

			int updatedRowCnt = 0;

			for (SeatVO seat : seatList) {
				int rowsUpdated = session.update("seat.dao.SeatDAO.updateAvailableToDB2", seat);
				updatedRowCnt += rowsUpdated;
			}

			if (updatedRowCnt < seatList.size()) {
				throw new Exception("Update failed.");
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		}
	}

	public void updateAvailableToDB3(List<SeatVO> seatList) throws Exception {
		try {
			session = new MyBatisConfig().getInstanceDB3();

			int updatedRowCnt = 0;

			for (SeatVO seat : seatList) {
				int rowsUpdated = session.update("seat.dao.SeatDAO.updateAvailableToDB3", seat);
				updatedRowCnt += rowsUpdated;
			}

			if (updatedRowCnt < seatList.size()) {
				throw new Exception("Update failed.");
			}
			session.commit();

		} catch (Exception e) {
			session.rollback();
			throw e;
		}
	}
}
