package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sample/*")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	//http://localhost:8088/sample/all
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public void doALL() throws Exception{
		logger.debug("/sample/all -> doALL() 실행");
	}
	
	//http://localhost:8088/sample/member
	@RequestMapping(value = "/member",method = RequestMethod.GET)
	public void doMember() throws Exception{
		logger.debug("/sample/member -> doMember() 실행");
	}
	
	//http://localhost:8088/sample/admin
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public void doAdmin() throws Exception{
		logger.debug("/sample/adminb -> doAdmin() 실행");
	}
	
	
	
}
