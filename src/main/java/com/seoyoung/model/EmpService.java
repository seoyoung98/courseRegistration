package com.seoyoung.model;

import java.util.List;

import com.seoyoung.dto.SubjectVO;

public class EmpService {
	EmpDAO dao = new EmpDAO();
	StudentDAO sdao = new StudentDAO();
	
	// 교직원
	// 직원 - 강의 추가
	public int insertSubject(SubjectVO subject) {
		return dao.insertSubject(subject);
	}

	// 직원 - 강의 수정
	public int updateSubject(SubjectVO subject) {
		return dao.updateSubject(subject);
	}

	// 직원 - 강의 삭제
	public int deleteSubject(String sub_id) {
		sdao.deleteEnrollStu(sub_id);
		return dao.deleteSubject(sub_id);
	}
	

	// 강의 목록 가져오기
	public List<SubjectVO> selectSubjectVO() {
		return dao.selectSubjectVO();
	}

	public SubjectVO selectSubInfo(String subId) {
		return dao.selectSubInfo(subId);
	}

}
