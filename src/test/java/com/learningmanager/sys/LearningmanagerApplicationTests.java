package com.learningmanager.sys;

import com.learningmanager.sys.entity.User;
import com.learningmanager.sys.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class LearningmanagerApplicationTests {
	@Resource
	private UserMapper userMapper;

	@Test
	void testMapper() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);

	}

}
