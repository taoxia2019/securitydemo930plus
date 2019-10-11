package com.lena;


import com.alibaba.fastjson.JSONArray;
import com.lena.base.result.Results;
import com.lena.dao.*;
import com.lena.dto.RoleDTO;
import com.lena.entity.Permission;
import com.lena.entity.RolePermission;
import com.lena.entity.Users;
import com.lena.service.PermissionService;
import com.lena.service.RoleService;
import com.lena.service.UserRoleService;
import com.lena.utils.TreeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Securitydemo930ApplicationTests {
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private  UserRoleMapper userRoleMapper;

	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private PermissionService permissionService;

	@Autowired
	private PermissionMapper permissionMapper;


	@Autowired
	private RolePermissionMapper rolePermissionMapper;


	@Resource
	DataSource dataSource;

	@Test
	public void contextLoads1() throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from sys_users where id='1'");
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			String name = resultSet.getString("username");
			System.out.println(name);
		}
	}



	@Test
	public void contextLoads() {

		//设置密码
		Users admin = usersMapper.getUser("admin");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 加密
		String encodedPassword = passwordEncoder.encode(admin.getPassword().trim());
		admin.setPassword(encodedPassword);

		usersMapper.updateById(admin);

	}
	@Test
	public void createTime() {
		//设置创建时间
		Users admin = usersMapper.getUser("admin");
		admin.setCreatetime(new Date());
		admin.setUpdatetime(new Date());
		usersMapper.updateById(admin);

	}

}
