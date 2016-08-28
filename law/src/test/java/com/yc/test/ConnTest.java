package com.yc.test;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//指明使用spring的测试框架来进行单元测试
@RunWith(SpringJUnit4ClassRunner.class)
//使用的spring的配置文件
@ContextConfiguration("classpath:spring.xml")

public class ConnTest {
	
	@Autowired
	//private SqlSessionFactory sqlSessionFactory;
	private DataSource dataSource;

	@Test
	public void testConn() {
		//Connection con=sqlSessionFactory.openSession().getConnection();
		Connection con=null;
		try {
			con = dataSource.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

