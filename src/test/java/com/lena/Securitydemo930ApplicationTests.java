package com.lena;


import com.lena.dao.RoleMapper;
import com.lena.dao.RolePermissionMapper;
import com.lena.dao.UserRoleMapper;
import com.lena.dao.UsersMapper;
import com.lena.dto.RoleDTO;
import com.lena.entity.RolePermission;
import com.lena.service.RoleService;
import com.lena.service.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
	private RolePermissionMapper rolePermissionMapper;





	@Test
	public void contextLoads() {
		List<Integer> integers = rolePermissionMapper.queryRolePermissionIdsByRid(1);
		integers.forEach(i-> System.out.println(i));


	}

}
