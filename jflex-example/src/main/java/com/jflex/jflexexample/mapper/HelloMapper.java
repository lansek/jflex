/*****************************************************************************************
 * Project Key : jflex-example
 * Create on 2021-1-15 11:42:55
 * Copyright (c) 2008 - 2021.深圳市快付通金融网络科技服务有限公司版权所有. 粤ICP备10228891号
 * 注意：本内容仅限于深圳市快付通金融网络科技服务有限公司内部传阅，禁止外泄以及用于其他的商业目的
 ****************************************************************************************/
package com.jflex.jflexexample.mapper;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.jflex.jflexexample.entity.User;

import org.apache.ibatis.annotations.Result;

/**
 * 
 * @author wangshaolin
 * @since
 */
public interface HelloMapper {

	@Select("SELECT name FROM t_jflextext WHERE id = #{id}")
	String getUserNameById(int id);
	
	@Select("SELECT * FROM t_jflextext WHERE id = #{id}")
	@Results(id="userMap",value = {
			@Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
			@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
	})
	User getUserById(int id);
}
