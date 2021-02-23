/*****************************************************************************************
 * Project Key : jflex-example
 * Create on 2021-1-6 9:41:08
 * Copyright (c) 2008 - 2021.深圳市快付通金融网络科技服务有限公司版权所有. 粤ICP备10228891号
 * 注意：本内容仅限于深圳市快付通金融网络科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ****************************************************************************************/
package com.jflex.jflexexample.web.hello;

import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.jflex.jflexexample.entity.User;
import com.jflex.jflexexample.mapper.HelloMapper;


/**
 * 
 * @author wangshaolin
 * @since
 */
@Service
public class FirstService {
	
	private static final Logger logger = LoggerFactory.getLogger(FirstService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HelloMapper helloMapper;

	public String getNameById(int id) {

		String sql = "SELECT name FROM t_jflextext WHERE id = ?";
		int[] argTypes = { Types.INTEGER };
		// 通过jdbcTemplate查询数据库
		String name = jdbcTemplate.queryForObject(sql, new Object[] { id }, argTypes, String.class);
		
		SqlRowSet row = jdbcTemplate.queryForRowSet("");
		//jdbcTemplate.

		return name;
	}
	
	public User getUserById(int id) {

		User user = helloMapper.getUserById(id);
		logger.info("Userinfo ,id is [{}],name is [{}]",user.getId(),user.getName());

		return user;
	}
}
