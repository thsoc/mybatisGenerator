package cn.com.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.conn.DataConnect;
import cn.com.sm.mapper.UserMapper;
import cn.com.sm.po.User;
import cn.com.sm.po.UserExample;

public class UserTest {
	@Test
	public void userTest() throws ParseException, IOException {
		DataConnect data = new DataConnect();
		SqlSession sqlSession = data.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo("¿Ó¿⁄¿⁄");
		criteria.andGenderNotEqualTo("≈Æ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		criteria.andBirthdayBetween(sdf.parse("1990-01-01"), sdf.parse("1994-01-01"));
		criteria.andEmailIsNotNull();
		List<User> list = userMapper.selectByExample(userExample);
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			System.out.println(user.getId()+":"+user.getUsername());
		}
		
	}
}
