package com.seoyoung.model;

import java.util.List;

import com.seoyoung.dto.*;

public class StudentService {
	StudentDAO dao = new StudentDAO();

	// 학생

	// 학생 정보 추가
	public int insertStudent(StudentVO student) {
		return dao.insertStudent(student);
	}

	// 강의 목록 가져오기
	public List<SubjectVO> selectSubjectVO() {
		return dao.selectSubjectVO();
	}


	// 로그인 체크 -> 학생의 모든 정보 가져오기
	public StudentVO loginCheck(String email, String password) {
		return dao.loginCheck(email, password);
	}

	// 학생 이메일 찾기
	public String findEmail(int stu_id) {
		String stu_email = dao.findEmail(stu_id);
		if(stu_email.isEmpty()) {
			return null;
		}
		return stu_email;
	}

	// 학생 비밀번호 찾기
	public String findPassword(String stu_email) {
		String stu_password = dao.findPassword(stu_email);
		if(stu_password.isEmpty()) {
			return null;
		}
		return stu_password;
	}

	public int insertEnroll(int stu_id, String sub_id) {
		
		return dao.insertEnroll(stu_id, sub_id);
	}

	// 
	public int deleteEnroll(int enroll_num) {
		return dao.deleteEnroll(enroll_num);
	}

	public List<EnrollListVO> enroll_join(int getId, String sub_id) {
		// TODO Auto-generated method stub
		return dao.enroll_join(getId, sub_id);
	}

	public List<EnrollListVO> enroll_list(int stu_id) {
		// TODO Auto-generated method stub
		return dao.enroll_list(stu_id);
	}

	// 비밀번호 수정
	public int updatePassword(String new_password, String stu_email) {
		// TODO Auto-generated method stub
		return dao.updatePassword(new_password, stu_email);
	}


	// 일단 값을 넣어야 한다.
	

}
