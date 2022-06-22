package com.itwillbs.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DBConnectTest {
	
	//DataSource객체
	@Inject
	private DataSource ds;
	
	private SqlSessionFactory fac;
	private SqlSession session;
	
	//주입이 정상인지 확인
	//@Test
	public void dataSourceTest() {
		System.out.println(ds);
	}
	
	//@Test
	public void factoryTest() {
		System.out.println(fac);
		
	}
	
	//@Test
	public void sessionTest() {
		System.out.println(session);
	}
	

}
