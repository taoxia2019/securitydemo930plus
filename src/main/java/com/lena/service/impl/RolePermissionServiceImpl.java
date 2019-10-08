package com.lena.service.impl;

import com.lena.entity.RolePermission;
import com.lena.dao.RolePermissionMapper;
import com.lena.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Override
    public List<Integer> queryRolePermissionIdsByRid(Integer roleid) {
        return rolePermissionMapper.queryRolePermissionIdsByRid(roleid);
    }
}
