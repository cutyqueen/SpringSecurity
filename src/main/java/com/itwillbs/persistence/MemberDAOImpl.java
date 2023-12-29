package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository(value = "memberDAO")
public class MemberDAOImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE ="com.itwillbs.mapper.MemberMapper";
	
	public MemberVO memberJoin() throws Exception {
		logger.debug("memberJoin() 실행");
		return sqlSession.selectOne(NAMESPACE+".getMemberJoin", "admin90");
	}
	
	
	
	
	
	
}
