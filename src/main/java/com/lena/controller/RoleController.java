package com.lena.controller;



import com.lena.base.result.PageTableRequest;
import com.lena.base.result.Results;
import com.lena.dto.RoleDTO;
import com.lena.entity.Role;

import com.lena.service.RolePermissionService;
import com.lena.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.xml.transform.Result;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author taoxia
 * @since 2019-09-30
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @ResponseBody
    @RequestMapping("/all")
    public Results<Role> getRoleAll(){

        return roleService.selectRoleAll();
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<Role> getRole(PageTableRequest page){
        page.countOffset();

        return roleService.getAllRolesByPage(page.getOffset(),page.getLimit());
    }

    @GetMapping("/findByFuzzyRoleName")
    @ResponseBody
    public Results<Role> findByFuzzyRoleName(PageTableRequest page,String rolename){
        page.countOffset();

        return roleService.findByFuzzyRoleName(rolename,page.getOffset(),page.getLimit());
    }

    @GetMapping("/add")
    public String addRole(Model model){
        model.addAttribute("role",new Role());
        return "role/role-add2";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<Role> saveRole(@RequestBody RoleDTO roleDTO){
        roleDTO.setCreatetime(LocalDateTime.now());
        roleDTO.setUpdatetime(LocalDateTime.now());

        return roleService.saveRole(roleDTO);
    }

    //跳转编辑页面
    @GetMapping("/edit")
    public String editUser(Model model,RoleDTO roleDTO){
        Role role1 = roleService.getById(roleDTO.getId());
        model.addAttribute(role1);
        return "role/role-edit";
    }

    @PostMapping("/edit")
    @ResponseBody
    public Results<Role> updateRole(@RequestBody RoleDTO roleDTO){
        roleService.updateRole(roleDTO);

        return Results.success();
    }

    //删除
    @GetMapping("/delete")
    @ResponseBody
    public Results deleteUser(RoleDTO roleDTO){
        return roleService.delete(roleDTO.getId());

    }


}

