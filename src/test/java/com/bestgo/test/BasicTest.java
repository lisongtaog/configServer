package com.bestgo.test;

import java.util.Date;

import com.bestgo.user.dto.UtiIUserDto;
import com.bestgo.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" })
public class BasicTest {

	@Autowired
	private UserService userService;

	@Test
	public void test() throws Exception {
		System.out.println("*******************服务测试开始*******************");
		
		UtiIUserDto userDto = new UtiIUserDto();


		System.out.println("*******************服务测试结束*******************");
	}

}
