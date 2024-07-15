package kr.ac.kopo.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.schedule.vo.ScheduleVO;
import kr.ac.kopo.seat.vo.SeatVO;
import kr.ac.kopo.util.MyBatisConfig;

public class ScheduleDAO {
	private SqlSession session;

	public ScheduleDAO() {
//		session = new MyBatisConfig().getInstance();
	}

	public List<ScheduleVO> selectWhereFromDB1(ScheduleVO schedule) {
		session = new MyBatisConfig().getInstanceDB1();
		List<ScheduleVO> list = session.selectList("schedule.dao.ScheduleDAO.selectWhereFromDB1", schedule);
		return list;
	}

	public List<ScheduleVO> selectWhereFromDB2(ScheduleVO schedule) {
		session = new MyBatisConfig().getInstanceDB2();
		List<ScheduleVO> list = session.selectList("schedule.dao.ScheduleDAO.selectWhereFromDB2", schedule);
		return list;
	}

	public List<ScheduleVO> selectWhereFromDB3(ScheduleVO schedule) {
		session = new MyBatisConfig().getInstanceDB3();
		List<ScheduleVO> list = session.selectList("schedule.dao.ScheduleDAO.selectWhereFromDB3", schedule);
		list.forEach(scheduleVO -> scheduleVO.setTheaterName("1"));
		return list;
	}

	public ScheduleVO selectByNoAssociationFromDB1(int no) {
		session = new MyBatisConfig().getInstanceDB1();
		ScheduleVO schedule = session.selectOne("schedule.dao.ScheduleDAO.selectByNoAssociationFromDB1", no);
		return schedule;
	}

	public ScheduleVO selectByNoAssociationFromDB2(int no) {
		session = new MyBatisConfig().getInstanceDB2();
		ScheduleVO schedule = session.selectOne("schedule.dao.ScheduleDAO.selectByNoAssociationFromDB2", no);
		return schedule;
	}

	public ScheduleVO selectByNoAssociationFromDB3(int no) {
		session = new MyBatisConfig().getInstanceDB3();
		ScheduleVO schedule = session.selectOne("schedule.dao.ScheduleDAO.selectByNoAssociationFromDB3", no);
		schedule.setTheaterName("1");
		List<String> nameList = new ArrayList<>();

		for (char letter = 'A'; letter <= 'H'; letter++) {
			for (int number = 1; number <= 10; number++) {
				String formattedNumber = String.format("%02d", number);
				String result = letter + formattedNumber;
				nameList.add(result);
			}
		}

		int idx = 0;
		for (SeatVO seat : schedule.getSeatList())
			seat.setSeatName(nameList.get(idx++));

		return schedule;
	}

	public ScheduleVO selectByNoFromDB1(int no) {
		session = new MyBatisConfig().getInstanceDB1();
		ScheduleVO schedule = session.selectOne("schedule.dao.ScheduleDAO.selectByNoFromDB1", no);
		return schedule;
	}

	public ScheduleVO selectByNoFromDB2(int no) {
		session = new MyBatisConfig().getInstanceDB2();
		ScheduleVO schedule = session.selectOne("schedule.dao.ScheduleDAO.selectByNoFromDB2", no);
		return schedule;
	}

	public ScheduleVO selectByNoFromDB3(int no) {
		session = new MyBatisConfig().getInstanceDB3();
		ScheduleVO schedule = session.selectOne("schedule.dao.ScheduleDAO.selectByNoFromDB3", no);
		schedule.setTheaterName("1");
		return schedule;
	}
}
