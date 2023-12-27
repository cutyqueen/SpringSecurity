package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 로그인 성공시 권한별로 페이지 이동
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		logger.debug("@@@ : CustomLoginSuccessHandler-onAuthenticationSuccess() 호출");
		logger.debug("@@@ : 사용자 로그인 성공!");
		
		// 사용자의 권한 정보를 저장
		List<String> roleNames = new ArrayList<String>();
		auth.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		logger.debug("roleNames: "+roleNames);
		
		// 각 권한별로 페이지 이동
		//ex)roleNames : [ROLE_ADMIN, ROLE_MEMBER] - 관리자
		//ex)roleNames : [ROLE_MEMBER] - 관리자일수도, 일반유저일수도
		if(roleNames.contains("ROLE_ADMIN")) {
			logger.debug("관리자 로그인 성공!");
			//페이지이동
			response.sendRedirect("/sample/admin");
			return; // 다음동작 하지 못하게
		}
		if(roleNames.contains("ROLE_MEMBER")) {
			logger.debug("일반 유저 로그인 성공!");
			//페이지 이동
			response.sendRedirect("/sample/member");
			return;
		}
		//그외 나머지
		response.sendRedirect("/sample/all");
		
		
	}
	
}
