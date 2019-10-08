package com.lena;


import com.alibaba.fastjson.JSONArray;
import com.lena.base.result.Results;
import com.lena.dao.*;
import com.lena.dto.RoleDTO;
import com.lena.entity.Permission;
import com.lena.entity.RolePermission;
import com.lena.service.PermissionService;
import com.lena.service.RoleService;
import com.lena.service.UserRoleService;
import com.lena.utils.TreeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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





	@Test
	public void contextLoads() {
		Integer i=1;
		List<Permission> datas = permissionMapper.listByUserId(i);
		datas.stream().filter(p -> p.getType().equals(1)).collect(Collectors.toList());
		JSONArray array = new JSONArray();
		TreeUtils.setPermissionsTree(0, datas, array);
		System.out.println(array);



	}

}
