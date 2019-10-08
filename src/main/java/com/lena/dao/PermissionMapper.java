package com.lena.dao;

import com.lena.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author taoxia
 * @since 2019-10-04
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("select p.* from sys_permission p inner join sys_role_permission rp on p.id=rp.permissionid where rp.roleid=#{roleid} order by p.sort")
    List<Permission> listByRoleid(Integer roleid);

}
