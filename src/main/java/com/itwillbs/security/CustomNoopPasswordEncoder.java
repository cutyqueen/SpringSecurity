package com.itwillbs.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 시큐리티 - JDBC 연결 테스트를 위한 임시 암호화 객체 
 * (실제 암호화 동작X)
 */
public class CustomNoopPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// 암호화 동작 수행
		// ex) a -> egj78 
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 암호화된 비밀번호를 기존의 비밀번호와 비교
		return rawPassword.equals(encodedPassword);
	}
	
}
