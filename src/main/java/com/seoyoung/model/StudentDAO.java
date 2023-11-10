package com.seoyoung.model;
// execute => 수행 결과로 boolean 타입의 값을 반환, 모든 구문 수행 가능

// executeQuery => 수행 결과로 resultset 객체의 값을 반환, select 구문을 수행
// executeUpdate => 수행 결과로 int 타입의 값을 반환, select을 제외한 구문을 수행 

import java.sql.*;
import java.util.*;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

import com.seoyoung.dto.*;
import com.seoyoung.util.*;

public class StudentDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int count;

	// 학생
	// 회원가입 - 학생 정보 추가하기
	public int insertStudent(StudentVO student) {
		String sql = "insert into student values (stu_id_seq.nextval, ?, ?, ?, ?, ?)";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, student.getStu_name());
			pst.setString(2, student.getStu_password());
			pst.setString(3, student.getStu_address());
			pst.setString(4, student.getStu_phone());
			pst.setString(5, student.getStu_email());
			count = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("이미 존재하는 정보입니다. 다시 입력해주세요.");
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn); // 질문하기
		}
		return count;
	}


	// 로그인 체크 email, password를 기준으로 정보 받아오기
	public StudentVO loginCheck(String email,String password) {
		StudentVO stu = null;
		String sql = "select * from student where stu_email=? and stu_password=?";
		System.out.println(email);
		System.out.println(password);
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				stu = make_stuList(rs);
			}
		} catch (SQLException e) {
			System.out.println("sql 문을 잘 쓰시오.");
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		
		return stu;
	}

	// 이메일 찾기
	public String findEmail(int stu_id) {
		String result = "";
		String sql = "select stu_email from student where stu_id = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, stu_id);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("stu_email");
			}
		} catch (SQLException e) {
			System.out.println("학생의 정보를 찾을 수 없습니다. 다시 입력해주세요.");
		} catch (Exception e) {
			System.out.println("학생의 정보를 찾을 수 없습니다. 다시 입력해주세요.");
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}

		return result;
	}

	// 비밀번호 찾기
	public String findPassword(String stu_email) {
		String result = "";
		String sql = "select stu_password from student where stu_email = ?";
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, stu_email);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getString("stu_password");
			}
		} catch (SQLException e) {
			System.out.println("이메일이 존재하지 않습니다. 다시 입력해주세요.");
		} catch (Exception e) {
			System.out.println("이메일이 존재하지 않습니다. 다시 입력해주세요.");
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}

		return result;
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
				// rs의 주소를 넘겨서 만들어서 준다?
				// reset에서 읽어서 vo 만들기
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

	private StudentVO make_stuList(ResultSet rs) throws SQLException {
		StudentVO list = new StudentVO();
		list.setStu_id(rs.getInt("stu_id"));
		list.setStu_name(rs.getString("stu_name"));
		list.setStu_email(rs.getString("stu_email"));
		list.setStu_password(rs.getString("stu_password"));
		list.setStu_address(rs.getString("stu_address"));
		list.setStu_phone(rs.getString("stu_phone"));
		return list;
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
		return list;
	}


	// 수강신청하기
	public int insertEnroll(int stu_id, String sub_id) {
//		String sql = "select st.*, su.* from student st join enrollment e on (st.stu_id = e.stuid) join subject su on su.sub_id = e.sub_id where stu_id = ?";
		String sql = "insert into Enrollment values (enroll_seq.nextval, ?, ?)";
		conn = DBUtil.getConnection();
		int count = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, stu_id);
			pst.setString(2, sub_id);
			count = pst.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();

		} // 통로 완료
		finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return count;
	}
	
	

	// 수강신청 - 수강 신청 취소하기
	public int deleteEnroll(int enroll_num) {
		String sql = "delete from enrollment where enroll_num = ?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, enroll_num);
			count = pst.executeUpdate();
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return count;
	}
	
	// 강의 삭제시 애들 다 삭제
	public int deleteEnrollStu(String sub_id) {
		String sql = "delete from enrollment where sub_id = ?";
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
		return count;
	}

	public List<EnrollListVO> enroll_join(int getId, String sub_id) {
		List<EnrollListVO> enrollList = new ArrayList<>();
		String sql = "select e.enroll_num, st.*, su.* from student st join enrollment e on (st.stu_id = e.stu_id) join subject su on su.sub_id = e.sub_id where st.stu_id = ? and su.sub_id = ?";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, getId);
			pst.setString(2, sub_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				EnrollListVO enroll = make_Enroll(rs);
				enrollList.add(enroll);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return enrollList;
	}

	private EnrollListVO make_Enroll(ResultSet rs) throws SQLException {
		EnrollListVO list = new EnrollListVO();
		list.setEnroll_num(rs.getInt("enroll_num"));
		list.setStu_id(rs.getInt("stu_id"));
		list.setStu_name(rs.getString("stu_name"));
		list.setSub_id(rs.getString("sub_id"));
		list.setSub_name(rs.getString("sub_name"));
		list.setProfessor_name(rs.getString("professor_name"));
		list.setClass_loc(rs.getString("class_loc"));
		list.setClass_time(rs.getInt("class_time"));
		list.setSub_credit(rs.getInt("sub_credit"));
		return list;
	}

	// 수강신청 - 내역 조회
	public List<EnrollListVO> enroll_list(int stu_id) {
		List<EnrollListVO> enrollList = new ArrayList<>();
		String sql = "select e.enroll_num, st.*, su.* from student st join enrollment e on (st.stu_id = e.stu_id) join subject su on (su.sub_id = e.sub_id) where st.stu_id = ?";
		conn = DBUtil.getConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, stu_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				EnrollListVO enroll = make_Enroll(rs);
				enrollList.add(enroll);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return enrollList;
	}

	public int updatePassword(String new_password, String stu_email) {
		String sql = "update student set stu_password = ? where stu_email = ?";
		int count = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, new_password);
			pst.setString(2, stu_email);
			count = pst.executeUpdate();
		} catch (SQLException e) {
		} finally {
			DBUtil.dbDisconnect(rs, pst, conn);
		}
		return count;
	}

}
