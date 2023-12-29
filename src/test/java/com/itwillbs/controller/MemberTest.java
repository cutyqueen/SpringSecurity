package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAOImpl;
import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/*-context.xml"}
						)
public class MemberTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	@Inject
	private DataSource ds;
	
	@Inject
	private PasswordEncoder pwEncoder;
	
	@Inject
	private MemberDAOImpl mdao;
	
	@Test
	 public void 회원정보조회_조인_테스트() throws Exception{
		 logger.debug(" 회원정보조회_조인_테스트()  실행 ");
		 
		 MemberVO resultVO = mdao.memberJoin();
		 
		 logger.debug(" resultVO : "+resultVO);		 
	 }
	
	
	
	
	//@Test
	public void 회원정보생성_테스트() throws Exception{
		Connection con = ds.getConnection();

		for(int i=0;i<100;i++) {
			String sql = "insert into tbl_member(userid,userpw,username,useremail) "
					+ "values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
			// 비밀번호는 모두 암호화
			pstmt.setString(2, pwEncoder.encode("1234"));
			
			if(i<80) {
				pstmt.setString(1, "user"+i);
				//pstmt.setString(2, "1234");
				pstmt.setString(3, "사용자"+i);
				pstmt.setString(4, "user"+i+"@itwill.com");
			}else if(i<90) {
				pstmt.setString(1, "member"+i);
				//pstmt.setString(2, "1234");
				pstmt.setString(3, "회원"+i);
				pstmt.setString(4, "member"+i+"@itwill.com");
			}else {
				pstmt.setString(1, "admin"+i);
				//pstmt.setString(2, "1234");
				pstmt.setString(3, "관리자"+i);
				pstmt.setString(4, "admin"+i+"@itwill.com");
			}
			
			pstmt.executeUpdate();		
		}//for
		
	}
	
	// 회원 정보에 따른 권한 설정
	//@Test
	public void 회원정보권한_테스트() throws Exception{
		
		Connection con = ds.getConnection();
		
		for(int i=0;i<100;i++) {
			String sql = "insert into tbl_member_auth (userid,auth) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			if(i<80) {
				pstmt.setString(1, "user"+i);
				pstmt.setString(2, "ROLE_USER");
			}else if(i<90) {
				pstmt.setString(1, "member"+i);
				pstmt.setString(2, "ROLE_MEMBER");
			}else {
				pstmt.setString(1, "admin"+i);
				pstmt.setString(2, "ROLE_ADMIN");
			}
			
			pstmt.executeUpdate();
		}//for
	}
	
	

	
}
