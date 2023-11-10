package com.seoyoung.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seoyoung.dto.SubjectVO;
import com.seoyoung.util.DBUtil;

public class EmpDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int count;

	// 교직원
	// 교직원 - 강의 추가
	public int insertSubject(SubjectVO subject) {
		String sql = "insert into subject(sub_id, major, sub_name, sub_credit, professor_name, class_loc, class_time) values (?, ?, ?, ?, ?, ?, ?)";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, subject.getSub_id());
			pst.setString(2, subject.getMajor());
			pst.setString(3, subject.getSub_name());
			pst.setInt(4, subject.getSub_credit());
			pst.setString(5, subject.getProfessor_name());
			pst.setString(6, subject.getClass_loc());
			pst.setInt(7, subject.getClass_time());
			count = pst.executeUpdate();
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return count;
	}

	// 강의 수정 - 교수님, 강의실 위치, 강의 시간 - 강의 번호를 기준으로
	public int updateSubject(SubjectVO subject) {
		String sql = "update subject set professor_name = ?, class_loc = ?, class_time = ? where sub_id = ?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(4, subject.getSub_id());
			pst.setString(1, subject.getProfessor_name());
			pst.setString(2, subject.getClass_loc());
			pst.setInt(3, subject.getClass_time());
			count = pst.executeUpdate();
		} catch (SQLException e) {
//				e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return count;
	}
	
	

	// 교직원 - sub_id를 기준으로 강의 삭제
	public int deleteSubject(String sub_id) {
		String sql = "delete from subject where sub_id = ?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, sub_id);
			count = pst.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		System.out.println(count);
		return count;
	}

	// 수강 신청 가능한 강의 목록 불러오기
	public List<SubjectVO> selectSubjectVO() {
		List<SubjectVO> subject_List = new ArrayList<>();
		String sql = "select * from subject order by major desc";
		
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			// 칼럼이 엄청 많을 때는 어떻게 돌려야 할까
			while (rs.next()) {
				SubjectVO subject = make_subList(rs);
				subject_List.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // 통로 완료
		finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return subject_List;
	}

	private SubjectVO make_subList(ResultSet rs) throws SQLException {
		SubjectVO list = new SubjectVO();
		list.setSub_id(rs.getString("sub_id"));
		list.setMajor(rs.getString("major"));
		list.setSub_name(rs.getString("sub_name"));
		list.setSub_credit(rs.getInt("sub_credit"));
		list.setProfessor_name(rs.getString("professor_name"));
		list.setClass_loc(rs.getString("class_loc"));
		list.setClass_time(rs.getInt("class_time"));
		list.setCount_stu(rs.getInt("count_stu"));
		System.out.println(list);
		return list;
	}

	public SubjectVO selectSubInfo(String subId) {
		SubjectVO sub = null;
		String sql = "select * from subject where sub_id=?";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, subId);
			rs = pst.executeQuery();
			while (rs.next()) {
				sub = make_subList(rs);
			}
		} catch (SQLException e) {
			System.out.println("sql 문을 잘 쓰시오.");
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		
		return sub;
	}

}
