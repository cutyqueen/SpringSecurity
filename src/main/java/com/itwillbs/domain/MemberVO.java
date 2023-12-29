package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	private String enabled;
	
	// 조인으로 생성되는 결과를 저장하는 변수 생성
	private List<AuthVO> authList;
	
}
